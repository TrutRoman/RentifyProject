# Rentify
## Rentify-Software system for automating the rental business (with an emphasis on the financial reporting and customer service module)

### Щоб запустити бекенд:
    cd rentify-backend

    .\mvnw spring-boot:run


### Щоб запустити фронтенд:
    cd rentify-frontend

    npm start

** **

### Для перегляду в MySQL який саме предмет орендований по назві і який саме клієнт по імені орендував:(в rental_orders)

    SELECT
        orders.id AS Замовлення_№, 
        users.full_name AS Клієнт, 
        items.name AS Орендоване_майно, 
        orders.start_time AS Час_видачі
    FROM rental_orders orders
    JOIN inventory_items items ON orders inventory_item_id = items.id
    JOIN users ON orders.client_id = users.id;

### Щоб зайти як Менеджер/Техспеціаліст(Механік), нам потрібен менеджер/техспеціаліст(механік) у базі даних:(в users)
    INSERT INTO rentify_db.users (full_name, phone, password, role) 
    VALUES ('Головний Менеджер', '+380990000000', 'admin123', 'MANAGER');


    INSERT INTO rentify_db.users (full_name, phone, password, role) 
    VALUES ('Головний Механік', '+380991111111', 'tech123', 'TECH');