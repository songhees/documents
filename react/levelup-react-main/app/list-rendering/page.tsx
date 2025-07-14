import React from 'react';

const people = [
  {
    name: '정태준',
    role: '공동 창립자 / CEO',
    imageUrl: 'profile/1.png',
  },
  {
    name: '김상진',
    role: '기술 이사',
    imageUrl: 'profile/2.png',
  },
  {
    name: '박준형',
    role: '마케팅 책임자',
    imageUrl: 'profile/3.png',
  },
  {
    name: '이하나',
    role: '인사 관리자',
    imageUrl: 'profile/4.png',
  },
  {
    name: '최다현',
    role: '디자인 책임자',
    imageUrl: 'profile/5.png',
  },
  {
    name: '윤서아',
    role: '영업 이사',
    imageUrl: 'profile/6.png',
  },
  {
    name: '유서연',
    role: '고객 서비스 매니저',
    imageUrl: 'profile/7.png',
  },
  {
    name: '손주호',
    role: '제품 매니저',
    imageUrl: 'profile/8.png',
  }
  // 기타 인물 정보 추가...
];

export default function Page() {
  return (
    <div className="py-24 bg-white sm:py-32">
      <div className="grid px-6 mx-auto max-w-7xl gap-x-8 gap-y-20 lg:px-8 xl:grid-cols-3">
        <div className="max-w-2xl">
          <h2 className="text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">리더십 팀을 소개합니다</h2>
          <p className="mt-6 text-lg leading-8 text-gray-600">
            자유로운 분위기 속에서도 높은 전문성을 가진 팀, 저희는 각자의 위치에서 최선을 다해 노력하고 있습니다. 팀워크와 혁신을 통해 새로운 가치를 창출해 나가고자 합니다.
          </p>
        </div>
        <ul role="list" className="grid gap-x-8 gap-y-12 sm:grid-cols-2 sm:gap-y-16 xl:col-span-2">
          {people.map((person) => (
            <li key={person.name}>
              <div className="flex items-center gap-x-6">
                <img className="w-16 h-16 rounded-full" src={person.imageUrl} alt="" />
                <div>
                  <h3 className="text-base font-semibold leading-7 tracking-tight text-gray-900">{person.name}</h3>
                  <p className="text-sm font-semibold leading-6 text-indigo-600">{person.role}</p>
                </div>
              </div>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}
