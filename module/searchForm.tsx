"use client";

import SelectBox, { Option } from "@/components/ui/SelectBox";
import { ChangeEventHandler, MouseEventHandler, useState } from "react";

export enum SearchFormType {
  SIMPLE,
}

export interface SearchFormProps {
  type?: SearchFormType;
  onChange?: (value: string | number) => void;
  onClick?: () => void;
  options?: Option[];
  onKeyWord?: ChangeEventHandler<HTMLInputElement>;
  placeholder?: string;
  selectPlaceholder?: string;
  value: string;
  hasFilter?: boolean;
  className?: string;
  children?: React.ReactNode;
}

export default ({
  onClick,
  onChange,
  onKeyWord,
  placeholder,
  selectPlaceholder,
  options = [],
  value,
  hasFilter = false,
  children,
}: SearchFormProps) => {
  const [activeFilter, setActiveFilter] = useState(false);
  return (
    <div className={"board-search " + (hasFilter ? "filter type2" : "")}>
      <div className="search-group">
        <input
          type="text"
          placeholder={placeholder}
          className="inp-search"
          onChange={(e) => {
            onKeyWord?.(e);
          }}
          autoComplete="off"
          value={value}
          onKeyUp={(e) => {
            if (e.key === "Enter") {
              console.log(e);
              onClick?.();
            }
          }}
        />
        <button type="button" className="btn-search" onClick={onClick}>
          검색
        </button>
      </div>
      {activeFilter && children}
    </div>
  );
};
