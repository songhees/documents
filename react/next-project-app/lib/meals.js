import sql from 'better-sqlite3';
import { resolve } from 'styled-jsx/css';

// db 가져올 db 이름
const db = sql('meals.db');

// async 를 붙이면 promise를 감싸 return 한다. 안붙이면 결과값 return 
export async function getMeals() {
    // 강제 지연 코드
    await new Promise((resolve) => setTimeout(resolve, 2000));

    // 강제 에러 발생 코드
    // throw new Error('Loading meals failed');
    
    // prepare : sql 문
    // all : select list, get : select one, run : insert, update
    return db.prepare('SELECT * FROM meals').all();
}

export function getMeal(slug) {
    // ? 에 들어가야될 데이터는 get의 파라미터로 넘겨준다. sql injection 공격을 막아줌
    return db.prepare('SELECT * FROM meals WHERE slug = ?').get(slug);
}