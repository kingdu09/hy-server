-- ============================================================
-- 和谊管理系统 建表基线（来源：业务需求与数据库设计文档.md）
-- 说明：表已在 Docker MySQL 中创建，此文件仅作为版本基线/文档，
--       默认不启用 spring.sql.init（见 application.properties）。
-- ============================================================

CREATE TABLE IF NOT EXISTS product_spec (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    code            VARCHAR(50)  NOT NULL UNIQUE COMMENT '型号编码，如 PE-绿-25-05-阻燃',
    name            VARCHAR(100) NOT NULL COMMENT '型号名称，如 PE绿色25mm阻燃松针',
    category        VARCHAR(20)  NOT NULL COMMENT '产品类别：NEEDLE-松针 / FABRIC-布料',
    unit            VARCHAR(10)  DEFAULT 'kg' COMMENT '计价单位，默认公斤',
    sale_price      DECIMAL(10,2) COMMENT '销售单价（元/kg）',
    description     VARCHAR(500) COMMENT '备注说明',
    status          TINYINT      DEFAULT 1 COMMENT '状态：1-启用 0-停用',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '产品型号表 - 定义松针和布料的规格型号';

CREATE TABLE IF NOT EXISTS raw_material (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    name            VARCHAR(100) NOT NULL COMMENT '原料名称，如 PE粒子、色母粒',
    unit            VARCHAR(10)  DEFAULT 'kg' COMMENT '计量单位，默认公斤',
    purchase_price  DECIMAL(10,2) COMMENT '最近采购单价（元/kg）',
    stock_kg        DECIMAL(10,2) DEFAULT 0 COMMENT '当前库存（公斤）',
    description     VARCHAR(500) COMMENT '备注说明',
    status          TINYINT      DEFAULT 1 COMMENT '状态：1-启用 0-停用',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '原料表 - 记录生产所需的各种塑胶原料';

CREATE TABLE IF NOT EXISTS supplier (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    name            VARCHAR(100) NOT NULL COMMENT '供应商名称',
    contact_person  VARCHAR(50) COMMENT '联系人',
    phone           VARCHAR(20) COMMENT '联系电话',
    address         VARCHAR(200) COMMENT '地址',
    status          TINYINT      DEFAULT 1 COMMENT '状态：1-启用 0-停用',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '供应商表 - 原料供应商信息';

CREATE TABLE IF NOT EXISTS customer (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    name            VARCHAR(100) NOT NULL COMMENT '客户名称',
    contact_person  VARCHAR(50) COMMENT '联系人',
    phone           VARCHAR(20) COMMENT '联系电话',
    address         VARCHAR(200) COMMENT '地址',
    status          TINYINT      DEFAULT 1 COMMENT '状态：1-启用 0-停用',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '客户表 - 购买松针/布料的客户信息';

CREATE TABLE IF NOT EXISTS employee (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    name            VARCHAR(50)  NOT NULL COMMENT '员工姓名',
    phone           VARCHAR(20) COMMENT '手机号',
    position        VARCHAR(50) COMMENT '职位/工种，如配料工、挤出工',
    base_salary     DECIMAL(10,2) DEFAULT 0 COMMENT '基本工资（元/月）',
    hire_date       DATE         COMMENT '入职日期',
    status          TINYINT      DEFAULT 1 COMMENT '状态：1-在职 0-离职',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '员工表 - 工厂员工基本信息';

CREATE TABLE IF NOT EXISTS production_order (
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    order_no            VARCHAR(50)  NOT NULL UNIQUE COMMENT '工单编号，如 PO-20261118-001',
    spec_id             BIGINT       NOT NULL COMMENT '产品型号ID，关联 product_spec 表',
    plan_quantity_kg    DECIMAL(10,2) NOT NULL COMMENT '计划产量（公斤）',
    actual_quantity_kg  DECIMAL(10,2) COMMENT '实际产量（公斤）',
    production_date     DATE         NOT NULL COMMENT '生产日期',
    status              VARCHAR(20)  DEFAULT 'PLANNED' COMMENT '状态：PLANNED-计划 IN_PROGRESS-生产中 COMPLETED-已完成',
    remark              VARCHAR(500) COMMENT '备注',
    created_at          DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at          DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '生产工单表 - 每天安排的生产任务';

CREATE TABLE IF NOT EXISTS purchase_order (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    material_id     BIGINT       NOT NULL COMMENT '原料ID，关联 raw_material 表',
    supplier_id     BIGINT       COMMENT '供应商ID，关联 supplier 表',
    quantity_kg     DECIMAL(10,2) NOT NULL COMMENT '采购重量（公斤）',
    unit_price      DECIMAL(10,2) NOT NULL COMMENT '采购单价（元/kg）',
    total_amount    DECIMAL(10,2) COMMENT '总金额 = 重量 × 单价',
    purchase_date   DATE         NOT NULL COMMENT '采购日期',
    remark          VARCHAR(500) COMMENT '备注',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '采购入库单 - 记录原料进货的重量和价格';

CREATE TABLE IF NOT EXISTS sales_order (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    customer_id     BIGINT       NOT NULL COMMENT '客户ID，关联 customer 表',
    spec_id         BIGINT       NOT NULL COMMENT '产品型号ID，关联 product_spec 表',
    quantity_kg     DECIMAL(10,2) NOT NULL COMMENT '订购数量（公斤）',
    unit_price      DECIMAL(10,2) NOT NULL COMMENT '销售单价（元/kg）',
    total_amount    DECIMAL(10,2) COMMENT '总金额 = 数量 × 单价',
    order_date      DATE         NOT NULL COMMENT '下单日期',
    delivery_date   DATE         COMMENT '约定交货日期',
    status          VARCHAR(20)  DEFAULT 'PENDING' COMMENT '状态：PENDING-待处理 CONFIRMED-已确认 SHIPPED-已发货 COMPLETED-已完成',
    remark          VARCHAR(500) COMMENT '备注',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '销售订单表 - 客户订购松针/布料的订单记录';

CREATE TABLE IF NOT EXISTS delivery_note (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    sales_order_id  BIGINT       NOT NULL COMMENT '关联销售订单ID',
    delivery_date   DATE         NOT NULL COMMENT '出货日期',
    quantity_kg     DECIMAL(10,2) NOT NULL COMMENT '出货重量（公斤）',
    unit_price      DECIMAL(10,2) NOT NULL COMMENT '出货单价（元/kg）',
    total_amount    DECIMAL(10,2) COMMENT '总金额 = 重量 × 单价',
    remark          VARCHAR(500) COMMENT '备注',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '出货单表 - 实际发给客户的货物记录';

CREATE TABLE IF NOT EXISTS work_report (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    order_id        BIGINT       NOT NULL COMMENT '关联生产工单ID',
    employee_id     BIGINT       NOT NULL COMMENT '员工ID，关联 employee 表',
    report_date     DATE         NOT NULL COMMENT '报工日期',
    output_kg       DECIMAL(10,2) NOT NULL COMMENT '产出重量（公斤）',
    remark          VARCHAR(500) COMMENT '备注',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '报工记录表 - 记录每位员工每天的产量，用于计算计件工资';

CREATE TABLE IF NOT EXISTS shift_schedule (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    employee_id     BIGINT       NOT NULL COMMENT '员工ID，关联 employee 表',
    schedule_date   DATE         NOT NULL COMMENT '排班日期',
    shift_type      VARCHAR(20)  NOT NULL COMMENT '班次：MORNING-早班 AFTERNOON-中班 NIGHT-晚班',
    work_hours      DECIMAL(4,1) DEFAULT 8 COMMENT '工作时长（小时）',
    overtime_hours  DECIMAL(4,1) DEFAULT 0 COMMENT '加班时长（小时）',
    remark          VARCHAR(500) COMMENT '备注',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '排班表 - 记录每位员工每天的排班情况';

CREATE TABLE IF NOT EXISTS piece_rate (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    spec_id         BIGINT       NOT NULL COMMENT '产品型号ID，关联 product_spec 表',
    process_name    VARCHAR(50)  NOT NULL COMMENT '工序名称，如配料、挤出、切粒、打包',
    unit_price      DECIMAL(10,4) NOT NULL COMMENT '计件单价（元/kg）',
    effective_date  DATE         COMMENT '生效日期',
    status          TINYINT      DEFAULT 1 COMMENT '状态：1-启用 0-停用',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '计件单价表 - 定义每种产品各工序的计件工资单价';

CREATE TABLE IF NOT EXISTS payroll (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    employee_id     BIGINT       NOT NULL COMMENT '员工ID，关联 employee 表',
    salary_month      VARCHAR(7)   NOT NULL COMMENT '工资月份，如 2026-11',
    piece_wage      DECIMAL(10,2) DEFAULT 0 COMMENT '计件工资（元）',
    overtime_pay    DECIMAL(10,2) DEFAULT 0 COMMENT '加班费（元）',
    deductions      DECIMAL(10,2) DEFAULT 0 COMMENT '扣款（元）',
    net_pay         DECIMAL(10,2) COMMENT '实发工资（元）= 计件工资 + 加班费 - 扣款',
    status          VARCHAR(20)  DEFAULT 'UNPAID' COMMENT '状态：UNPAID-未发放 PAID-已发放',
    remark          VARCHAR(500) COMMENT '备注',
    created_at      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '工资月报表 - 每月员工工资汇总记录';
