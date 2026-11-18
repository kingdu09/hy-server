-- ============================================================
-- 和谊管理系统 测试数据（永丰塑胶·2026-11）
-- 13 张表全量数据，外键关系完整，按依赖顺序插入
-- 覆盖：松针/布料型号 → 原料/供应商 → 客户/员工 → 工单/报工
--       → 采购/销售/出货 → 排班/计件单价/工资
-- ============================================================

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE payroll;
TRUNCATE TABLE shift_schedule;
TRUNCATE TABLE work_report;
TRUNCATE TABLE delivery_note;
TRUNCATE TABLE sales_order;
TRUNCATE TABLE purchase_order;
TRUNCATE TABLE production_order;
TRUNCATE TABLE piece_rate;
TRUNCATE TABLE employee;
TRUNCATE TABLE customer;
TRUNCATE TABLE supplier;
TRUNCATE TABLE raw_material;
TRUNCATE TABLE product_spec;
SET FOREIGN_KEY_CHECKS = 1;

-- 1. 产品型号（2 松针 + 2 布料）
INSERT INTO product_spec (id, code, name, category, unit, sale_price, description, status) VALUES
 (1,'PE-绿-25-05-阻燃','PE翠绿25mm阻燃松针','NEEDLE','kg',12.50,'圣诞树用松针，主销款',1),
 (2,'PP-墨绿-38-05-阻燃','PP墨绿38mm阻燃松针','NEEDLE','kg',14.00,'高档长针松针',1),
 (3,'PP-红-010-12','PP红色0.10mm布料','FABRIC','kg',9.80,'圣诞红装饰布料',1),
 (4,'PE-金-005-10','PE金色0.05mm布料','FABRIC','kg',8.50,'金色礼品包装布料',1);

-- 2. 原料
INSERT INTO raw_material (id, name, unit, purchase_price, stock_kg, description, status) VALUES
 (1,'PE粒子','kg',8.50,5000,'聚乙烯原料',1),
 (2,'PP粒子','kg',7.80,4200,'聚丙烯原料',1),
 (3,'绿色色母粒','kg',22.00,300,'松针着色用',1),
 (4,'阻燃剂','kg',15.00,500,'阻燃处理添加剂',1);

-- 3. 供应商
INSERT INTO supplier (id, name, contact_person, phone, address, status) VALUES
 (1,'东莞塑胶原料有限公司','王经理','13800138001','东莞市长安镇工业区',1),
 (2,'佛山色母厂','李经理','13800138002','佛山市南海区',1),
 (3,'中山助剂有限公司','赵经理','13800138003','中山市火炬开发区',1);

-- 4. 客户
INSERT INTO customer (id, name, contact_person, phone, address, status) VALUES
 (1,'义乌圣诞树工艺品厂','陈老板','13900139001','浙江义乌',1),
 (2,'欧美节日用品贸易公司','John Smith','13900139002','广东深圳',1),
 (3,'义乌外贸批发商行','周经理','13900139003','浙江义乌',1);

-- 5. 员工
INSERT INTO employee (id, name, phone, position, base_salary, hire_date, status) VALUES
 (1,'张伟','13811110001','配料工',4500,'2024-03-01',1),
 (2,'李娜','13811110002','挤出工',5000,'2024-05-10',1),
 (3,'王强','13811110003','切粒工',4800,'2024-07-15',1),
 (4,'刘芳','13811110004','打包工',4200,'2025-02-20',1),
 (5,'陈杰','13811110005','机长',6000,'2023-11-08',1);

-- 6. 生产工单
INSERT INTO production_order (id, order_no, spec_id, plan_quantity_kg, actual_quantity_kg, production_date, status, remark) VALUES
 (1,'PO-20261114-001',1,500,500,'2026-11-14','COMPLETED','按时完成'),
 (2,'PO-20261115-001',2,300,310,'2026-11-15','COMPLETED','超产10kg'),
 (3,'PO-20261116-001',3,800,780,'2026-11-16','COMPLETED','原料略缺'),
 (4,'PO-20261117-001',1,600,590,'2026-11-17','COMPLETED',NULL),
 (5,'PO-20261118-001',4,400,NULL,'2026-11-18','IN_PROGRESS','生产中');

-- 7. 计件单价（按型号×工序）
INSERT INTO piece_rate (id, spec_id, process_name, unit_price, effective_date, status) VALUES
 (1,1,'配料',0.5000,'2026-01-01',1),
 (2,1,'挤出',1.2000,'2026-01-01',1),
 (3,1,'切粒',0.6000,'2026-01-01',1),
 (4,1,'打包',0.3000,'2026-01-01',1),
 (5,2,'配料',0.5500,'2026-01-01',1),
 (6,2,'挤出',1.4000,'2026-01-01',1),
 (7,2,'切粒',0.7000,'2026-01-01',1),
 (8,2,'打包',0.3000,'2026-01-01',1),
 (9,3,'配料',0.4000,'2026-01-01',1),
 (10,3,'挤出',1.0000,'2026-01-01',1),
 (11,3,'切粒',0.5000,'2026-01-01',1),
 (12,3,'打包',0.2500,'2026-01-01',1);

-- 8. 采购入库
INSERT INTO purchase_order (id, material_id, supplier_id, quantity_kg, unit_price, total_amount, purchase_date, remark) VALUES
 (1,1,1,2000,8.50,17000.00,'2026-11-10','PE粒子月度备货'),
 (2,2,1,1500,7.80,11700.00,'2026-11-12','PP粒子月度备货'),
 (3,3,2,100,22.00,2200.00,'2026-11-13','绿色母粒'),
 (4,4,3,80,15.00,1200.00,'2026-11-15','阻燃剂');

-- 9. 销售订单
INSERT INTO sales_order (id, customer_id, spec_id, quantity_kg, unit_price, total_amount, order_date, delivery_date, status, remark) VALUES
 (1,1,1,1000,12.50,12500.00,'2026-11-15','2026-11-22','SHIPPED','已分两批出货'),
 (2,2,2,800,14.00,11200.00,'2026-11-16','2026-11-24','CONFIRMED','出口订单'),
 (3,3,3,1200,9.80,11760.00,'2026-11-17','2026-11-25','PENDING','待排产'),
 (4,1,1,500,12.50,6250.00,'2026-11-18','2026-11-28','PENDING','追加订单');

-- 10. 出货单（销售订单1分两批出完 600+400=1000）
INSERT INTO delivery_note (id, sales_order_id, delivery_date, quantity_kg, unit_price, total_amount, remark) VALUES
 (1,1,'2026-11-20',600,12.50,7500.00,'第一批'),
 (2,1,'2026-11-21',400,12.50,5000.00,'第二批');

-- 11. 报工记录（工单1/2/3）
INSERT INTO work_report (id, order_id, employee_id, report_date, output_kg, remark) VALUES
 (1,1,1,'2026-11-14',120,'配料'),
 (2,1,2,'2026-11-14',200,'挤出'),
 (3,1,3,'2026-11-14',100,'切粒'),
 (4,1,4,'2026-11-14',80,'打包'),
 (5,2,2,'2026-11-15',160,'挤出'),
 (6,2,3,'2026-11-15',90,'切粒'),
 (7,2,4,'2026-11-15',60,'打包'),
 (8,3,1,'2026-11-16',300,'配料'),
 (9,3,5,'2026-11-16',200,'机长巡检'),
 (10,3,2,'2026-11-16',280,'挤出');

-- 12. 排班
INSERT INTO shift_schedule (id, employee_id, schedule_date, shift_type, work_hours, overtime_hours, remark) VALUES
 (1,1,'2026-11-14','MORNING',8,0,NULL),
 (2,2,'2026-11-14','MORNING',8,2,'加班2小时'),
 (3,3,'2026-11-14','AFTERNOON',8,0,NULL),
 (4,4,'2026-11-14','AFTERNOON',8,0,NULL),
 (5,5,'2026-11-14','NIGHT',8,1,'夜班'),
 (6,1,'2026-11-15','MORNING',8,0,NULL),
 (7,2,'2026-11-15','MORNING',8,1,NULL),
 (8,3,'2026-11-15','AFTERNOON',8,0,NULL),
 (9,4,'2026-11-15','AFTERNOON',8,0,NULL),
 (10,5,'2026-11-15','NIGHT',8,0,NULL);

-- 13. 工资月报（net_pay = 计件工资 + 加班费 - 扣款）
INSERT INTO payroll (id, employee_id, salary_month, piece_wage, overtime_pay, deductions, net_pay, status, remark) VALUES
 (1,1,'2026-11',4200.00,0.00,100.00,4100.00,'UNPAID','全勤'),
 (2,2,'2026-11',5600.00,300.00,0.00,5900.00,'UNPAID','加班较多'),
 (3,3,'2026-11',4800.00,50.00,50.00,4800.00,'UNPAID',NULL),
 (4,4,'2026-11',3900.00,0.00,0.00,3900.00,'UNPAID',NULL),
 (5,5,'2026-11',6000.00,150.00,200.00,5950.00,'UNPAID','机长岗位');
