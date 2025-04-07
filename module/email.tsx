"use client";

import { useEffect, useMemo, useState } from "react";
import SelectBox, { Option } from "./SelectBox";

export interface EmailInfo {
  domain: string;
  customDomain: string;
  emailId: string;
}

/**
 * onChange : email Component에서 만들어진 full email을 전달
 * defalutValue : 기본 full email
 * options : domain List
 */
interface EmailProps {
  placeholder?: string;
  onChange: (value: string | number) => void;
  defaultValue?: string;
  options?: Option[];
}

const Email = ({
  placeholder,
  onChange,
  options = [
    { value: "", label: "직접 입력" },
    { value: "naver.com", label: "naver.com" },
    { value: "daum.com", label: "daum.com" },
    { value: "google.com", label: "google.com" },
  ],
  defaultValue,
}: EmailProps) => {
  const [email, setEmail] = useState<EmailInfo>({
    domain: "",
    customDomain: defaultValue?.split("@")[1] || "",
    emailId: defaultValue?.split("@")[0] || "",
  });

  /**
   * input event function
   * @param param0
   */
  const handleInputChange = ({
    name,
    value,
  }: {
    name: string;
    value: string | number;
  }) => {
    setEmail((prev) => {
      const newEmail = { ...prev, [name]: value };
      onChange(
        newEmail.emailId && newEmail.customDomain
          ? `${newEmail.emailId}@${newEmail.customDomain}`
          : ""
      );
      return newEmail;
    });
  };

  /**
   * 초기값 변경에 따른 state 변경
   */
  useMemo(() => {
    setEmail({
      domain: "",
      customDomain: defaultValue?.split("@")[1] || "",
      emailId: defaultValue?.split("@")[0] || "",
    });
  }, [defaultValue]);

  return (
    <div className="inp-group-mail">
      <div>
        <input
          maxLength={20}
          type="text"
          className="inp-frm w300"
          placeholder={placeholder}
          name="emailId"
          value={email.emailId}
          onChange={(e) => handleInputChange(e.target)}
        />
        <span className="at">@</span>
      </div>
      <input
        maxLength={20}
        type="text"
        className="inp-frm w300"
        name="customDomain"
        value={email.customDomain}
        onChange={(e) => handleInputChange(e.target)}
      />
      <div className="select w200">
        <SelectBox
          placeholder="직접 입력"
          options={options}
          onChange={(value) =>
            handleInputChange({ name: "customDomain", value })
          }
          defaultValue={
            options.find((opt) => opt.value === email.customDomain)?.value
          }
        />
      </div>
    </div>
  );
};

export default Email;
