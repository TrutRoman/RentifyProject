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

---
---
# Rentify APM (Automated Property Management) 🛴🚲🔧

Rentify — це повноцінна Full-Stack система для автоматизації прокату майна. Проєкт охоплює весь бізнес-цикл: від реєстрації клієнтів та видачі інвентарю до технічного обслуговування на СТО та перегляду аналітики.

## 🚀 Головні можливості (Features)
* **Система ролей (RBAC):** Ізольовані робочі простори для Менеджера (керування каталогом), Клієнта (історія оренди) та Техніка (панель ремонту).
* **Real-time сповіщення:** Інтеграція WebSockets (STOMP) для миттєвого інформування менеджерів про завершення ремонту майна без оновлення сторінки.
* **Бізнес-аналітика:** Візуалізація популярності інвентарю за допомогою інтерактивних графіків.
* **Сучасний UX:** Плавні анімації прогресу ремонту та інтегровані спливаючі повідомлення (Toastify) замість системних alert-вікон.

## 🛠 Технологічний стек
* **Бекенд:** Java, Spring Boot, Spring Data JPA, WebSockets.
* **Фронтенд:** React.js, Axios, React-Toastify, Recharts.
* **База даних:** MySQL.

## ⚙️ Інструкція із запуску

### 1. База даних (MySQL)
1. Створіть базу даних `rentify_db`.
2. Spring Boot автоматично згенерує необхідні таблиці при першому запуску завдяки налаштуванню `spring.jpa.hibernate.ddl-auto=update`.

### 2. Запуск Бекенду (Java / Spring Boot)
1. Відкрийте папку `rentify-backend` у вашій IDE.
2. Завантажте Maven-залежності (`pom.xml`).
3. Запустіть головний клас додатку. Сервер стартує на порту `8080`.

### 3. Запуск Фронтенду (React)
1. Перейдіть у директорію клієнта: `cd rentify-frontend`
2. Встановіть усі необхідні npm-пакети: `npm install`
3. Запустіть локальний сервер розробки: `npm start`
4. Додаток автоматично відкриється у браузері за адресою: `http://localhost:3000`

## 👤 Автор
* **Роман Трут**