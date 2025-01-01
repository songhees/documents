import fs from 'node:fs';
import sql from 'better-sqlite3';
import slugify from 'slugify';
import xss from 'xss';

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

export async function saveMeal(meal) {
    meal.slug = slugify(meal.title, {lower: true});
    meal.insturctions = xss(meal.insturctions)

    const extension = meal.image.name.split('.').pop();
    const fileName = `${meal.slug}.${extension}`

    const stream = fs.createWriteStream(`public/images/${fileName}`)
    const bufferedImage = await meal.image.arrayBuffer();
    
    stream.write(Buffer.from(bufferedImage), (error) => {
        if (error) {
            throw new Error('Saving image failed!');
        }
    });

    meal.image = `/images/${fileName}`

    // @fieldname 을 이용하여 특정 필드를 연결할 수 있다. 함수에 객체를 인수로 전달한다.
    // 전달받은 객체에 해당 속성  이름들을 찾아서 값을 할당 해준다.
    db.prepare(`
        INSERT INTO meals
            (title, summary, instructions, creator, creator_email, image, slug)
        VALUES
            (
                @title,
                @summary,
                @instructions,
                @creator,
                @creator_email,
                @image,
                @slug
            )
    `).run(meal);
}