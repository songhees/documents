import Vue from 'vue';
import App from './App.vue';
import store from './store';


function formatComma(v) {
  if (v == null || v === '') return '';
  const s = String(v).replace(/,/g, '').replace(/[^\d.-]/g, '');
  if (s === '' || s === '-') return s;

  const neg = s.startsWith('-');
  const [iRaw, dRaw] = (neg ? s.slice(1) : s).split('.');
  const i = (iRaw || '0').replace(/\B(?=(\d{3})+(?!\d))/g, ',');
  return (neg ? '-' : '') + (dRaw != null ? `${i}.${dRaw}` : i);
}

Vue.directive('number-comma-text', {
  bind(el, binding) {
    el.textContent = formatComma(binding.value);
  },
  update(el, binding) {
    el.textContent = formatComma(binding.value);
  }
});

Vue.directive("minus-number-comma", function(el, binding) {
  if (el.value !== "" && el.value !== "-") {
    let number = el.value.replace(/[^-?\d+$]/g, "");
    number = Number(number);
    let pow = Math.pow(10, 0);
    number = (Math.floor(number * pow) / pow)
      .toString()
      .replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    el.value = number;
  }
});

Vue.directive("number-exchg-comma", {
  update: function(el, binding, vnode) {
    let initNum = el.value;
    let intPart;
    let demicalPart;
    let type;

    if (initNum === "") {
      return "";
    }

    // 소수점이 있는 경우
    if (initNum.includes(".")) {
      let numArr = initNum.split(".");
      intPart = numArr[0];
      // 소수점 8자리 제한
      demicalPart = numArr[1].substring(0, 8);

      if (demicalPart.length < 2) {
        type = "D";
      } else {
        if (0 === Number(demicalPart)) {
          type = "I";
          el.value = intPart;
        } else {
          type = "D";
        }
      }
    } else {
      type = "I";
    }

    if (type === "I") {
      let number = el.value.replace(/[^0-9]/g, "");
      number = Number(number);
      let pow = Math.pow(10, 0);
      el.value = (Math.floor(number * pow) / pow)
        .toString()
        .replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    } else {
      let pow = Math.pow(10, 2);
      intPart = intPart.replace(/[^0-9]/g, "");
      intPart = (Math.floor(intPart * pow) / pow)
        .toString()
        .replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      el.value = intPart + "." + demicalPart;
    }

    let event = new Event('input', { bubbles: true });
    el.dispatchEvent(event);
  }
});

new Vue({
  el: '#app',
  store,
  render: (h) => h(App),
});
