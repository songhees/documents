import clsx from 'clsx';
import React from 'react';

export const Boundary = ({
  children,
  labels = ['children'],
  size = 'default',
  type = 'client', // 'server' 또는 'client'
}: {
  children: React.ReactNode;
  labels?: string[];
  size?: 'small' | 'default';
  type?: 'server' | 'client';
}) => {
  return (
    <div
      className={clsx('relative rounded-lg border p-4 space-y-2', {
        'p-3 lg:p-5': size === 'small',
        'p-4 lg:p-9': size === 'default',
        'border-gray-300 border-solid  bg-white': type === 'client',
        'border-gray-500 border-dashed bg-gray-100': type === 'server',
      })}
    >
      <div
        className={clsx(
          'absolute -top-0.5 flex gap-x-1 text-[9px] uppercase leading-4 tracking-widest',
          {
            'left-3 lg:left-5': size === 'small',
            'left-4 lg:left-9': size === 'default',
          },
        )}
      >
        {labels.map((label) => (
          <div
            key={label}
            className={clsx('rounded-full px-1.5 shadow-[0_0_1px_1px_gray]', {
              'bg-gray-100 text-gray-600': type === 'client',
              'bg-gray-500 text-white': type === 'server',
            })}
          >
            {label}
          </div>
        ))}
      </div>
      {children}
    </div>
  );
};
