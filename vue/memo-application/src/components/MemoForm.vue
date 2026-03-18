<template>
  <div class="memo-form">
    <form @submit.prevent="addMemo">
        <fieldset>
            <div>

              <span class="" v-number-comma-text="addMoney"></span>
              <input class="memo-form__title-form" v-model="vvv">
              <!-- 또는 -->
              <input class="memo-form__title-form" v-minus-number-comma v-model="rmador" type="text" placeholder="입력해주세요."/>
                <input class="memo-form__title-form" v-model="nnn" v-number-exchg-comma type="text" placeholder="v-custom directive 금액을 입력해주세요."/>
                <input class="memo-form__title-form" :value="wwww | numberExchangeComma" @input="numberValidation" 
                  @blur="onBlur" type="text" placeholder="input + filter 입력해주세요."/>
                <input
                class="memo-form__title-form"
                type="text"
                  :value="totAmt"
                  @input="onNumberInput('totAmt', $event, 3)"
                  @blur="onNumberBlur('totAmt', $event, 3)"

                  placeholder="입력 input event"
                />
                <input class="memo-form__title-form" v-model="title"
                type="text" placeholder="메모의 제목을 입력해주세요."/>
                <textarea class="memo-form__content-form"
                placeholder="메모의 내용을 입력해주세요." v-model="content"></textarea>
                <button type="reset"><i class="fas fa-sync-alt"></i></button>
            </div>
            <button type="submit">등록하기</button>
        </fieldset>
    </form>
  </div>
</template>

<script>
export default {
  name: 'MemoForm',
  data() {
    return {
      vvv: 0,
      rmador: '',
      money: 1000000,
      nnn: '',
      wwww: 0,
      title: '',
      content: '',
      totAmt: '',
      minus: 123,
    };
  },
  computed: {
    addMoney() {
      return this.vvv - this.minus;
    },
  }, 
  filters: {
    numberExchangeComma(value) {
      value = value.toString()
      let index = value.indexOf(".");
      if (index != -1 && ++index != value.length) {
        value = value.substring(0, index+4);
        return value.replace(/(\d)(?=(\d{3})+(?:\.\d+)$)/g, "$1,")
      } else {
        return value.replace(/\B(?=(\d{3})+(?!\d))/g, ",")
      }
    }
  },
  methods: {
    onBlur($event) {
      if (!$event.target.value) {
        $event.target.value = 0;
        this.wwww = 0;
      }
    },
    /** 숫자 validation */
    numberValidation($event) {
      let initNum = $event.target.value;
      let intPart;
      let demicalPart;
      let type;
      if (initNum === "") {
        return "";
      }
      if (initNum.includes(".")) {
        let numArr = initNum.split(".");
        intPart = numArr[0];
        demicalPart = numArr[1];

        if (demicalPart.length >= 0) {
          type = "D";
        } else {
          type = "I";
        }
      } else {
        type = "I";
      }

      if (type === "I") {
        let number = $event.target.value.replace(/[^0-9]/g, "");
        number = Number(number);
        let pow = Math.pow(10, 0);
        this.wwww = number;
        $event.target.value = (Math.floor(number * pow) / pow)
          .toString()
      } else {
        let pow = Math.pow(10, 2);
        intPart = intPart.replace(/[^0-9]/g, "");
        demicalPart = demicalPart.substring(0, 3);
        this.wwww = intPart + "." + demicalPart;
        intPart = (Math.floor(intPart * pow) / pow)
          .toString()
        $event.target.value = intPart + "." + demicalPart;
      }
    },
    addMemo() {
    //  const id = new Date().getTime();
      const {title, content} = this;

      const isEmpty = title.length <= 0 || content.length <= 0;
      if (isEmpty) {
        return false;
      }
      this.$emit('addMemo', {title, content});
      this.resetFields();
    },
    resetFields() {
      this.title = '';
      this.content = '';
    },
        // 소수 n자리까지 절사(버림), 숫자/점만 허용(음수 필요 없으면 - 제거)
    normalizeNumberString(input, scale = 0) {
      if (input == null) return "";

      // 1) 콤마 제거 + 공백 제거
      let s = String(input).replace(/,/g, "").trim();

      // 2) 숫자/점만 허용 (음수 허용이면 /[^\d.-]/g 로 바꾸고 - 정리 로직 추가)
      s = s.replace(/[^\d.]/g, "");

      // 3) 점은 1개만 허용
      const firstDot = s.indexOf(".");
      if (firstDot !== -1) {
        s = s.slice(0, firstDot + 1) + s.slice(firstDot + 1).replace(/\./g, "");
      }

      // 4) "123." 같은 케이스는 그대로 두거나 blur에서 처리
      const parts = s.split(".");
      const intPart = parts[0] || "";
      const decPart = parts[1] != null ? parts[1].slice(0, scale) : null;

      if (scale === 0) return intPart.replace(/^0+(?=\d)/, ""); // 00012 -> 12
      if (decPart == null) return intPart;
      return `${intPart}.${decPart}`;
    },

    formatComma(raw) {
      if (raw == null) return "";
      const s = String(raw);
      if (s === "" || s === ".") return "";
      if (s.endsWith(".")) return s.replace(/\B(?=(\d{3})+(?!\d))/g, ","); // 123. 유지

      const [i, d] = s.split(".");
      const intFmt = (i || "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      return d != null ? `${intFmt}.${d}` : intFmt;
    },
    onNumberInput(path, e, scale) {
      const raw = this.normalizeNumberString(e.target.value, scale);
      // data 갱신(공통)
      this.$set(this, path, raw); // path가 1-depth면 OK
      // 화면은 렌더링(:value)에서 formatComma로 처리하는 걸 추천
    },
    onNumberBlur(path, e, scale) {
      let raw = this.normalizeNumberString(e.target.value, scale);

      // "."로 끝나면 점 제거, 빈 값이면 0 처리(정책)
      if (raw.endsWith(".")) raw = raw.slice(0, -1);
      if (raw === "") raw = "0";

      this.$set(this, path, raw);
    },
  },
  watch: {
    // nnn(value) {
    //   this.money = value*2;
    // },
  },
};
</script>

<style scoped>
.memo-form {
    margin-bottom: 24px;
    padding-bottom: 40px;
    border-bottom: 1px solid #eee;
}

.memo-form form fieldset div {
    position: relative;
    padding: 24px;
    margin-bottom: 20px;
    box-shadow: 0 4px 10px -4px rgba(0, 0, 0, 0.2);
    background-color: #ffffff;
}

.memo-form form fieldset div button[type="reset"] {
    position: absolute;
    right: 20px;
    bottom: 20px;
    font-size: 16px;
    background: none;
}

.memo-form form fieldset button[type="submit"] {
    float: right;
    width: 96px;
    padding: 12px 0;
    border-radius: 4px;
    background-color: #ff5a00;
    color: #fff;
    font-size: 16px;
}

.memo-form form fieldset .memo-form__title-form {
    width: 100%;
    margin-bottom: 12px;
    font-size: 18px;
    line-height: 26px;
}

.memo-form form fieldset .memo-form__content-form {
    width: 100%;
    height: 66px;
    font-size: 14px;
    line-height: 22px;
    vertical-align: top;
}

.memo-form input:focus {
    outline: none;
}
</style>
