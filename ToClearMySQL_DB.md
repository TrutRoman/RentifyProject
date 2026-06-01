-- 1. Вимикаємо захист і перевірку зовнішніх ключів (щоб база дозволила видалити історію)
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0;

-- 2. ПОВНІСТЮ ОЧИЩАЄМО ІСТОРІЮ ЗАМОВЛЕНЬ (всі тестові видачі і повернення зникнуть)
-- Якщо твоя таблиця називається інакше (наприклад, orders), зміни назву тут:
TRUNCATE TABLE rentify_db.rental_order; 
-- (або TRUNCATE TABLE rentify_db.orders; залежно від того, як Spring її назвав)

-- 3. Робимо ВСЕ майно знову доступним (AVAILABLE)
UPDATE rentify_db.inventory_items SET status = 'AVAILABLE';

-- 4. Відправляємо рівно один предмет на СТО для Техніка (наприклад, електросамокат Ninebot)
UPDATE rentify_db.inventory_items 
SET status = 'MAINTENANCE' 
WHERE name LIKE '%Ninebot Max%' 
LIMIT 1;

-- 5. Вмикаємо захист назад
SET FOREIGN_KEY_CHECKS = 1;
SET SQL_SAFE_UPDATES = 1;