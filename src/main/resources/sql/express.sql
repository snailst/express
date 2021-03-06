-- 订单表
DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
  id                  BIGINT PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键',
  express_code        VARCHAR(30) UNIQUE NOT NULL
  COMMENT '快递单号',
  create_at           DATETIME           DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  customer_name       VARCHAR(100)       NOT NULL
  COMMENT '客户名称',
  mobile_number       VARCHAR(11)        NOT NULL
  COMMENT '手机号码',
  goods_id            BIGINT             NOT NULL
  COMMENT '商品ID',
  goods_spec_id       BIGINT             NULL
  COMMENT '商品规格ID',
  goods_num           DOUBLE             NOT NULL
  COMMENT '商品数量',
  agent_name          VARCHAR(100) COMMENT '代理名称',
  agent_mobile_number VARCHAR(11) COMMENT '代理电话',
  address             VARCHAR(300)       NOT NULL
  COMMENT '收件地址',
  province            VARCHAR(50) COMMENT '省',
  city                VARCHAR(50) COMMENT '市',
  county              VARCHAR(50) COMMENT '县',
  town                VARCHAR(50) COMMENT '镇/乡/区',
  street              VARCHAR(300) COMMENT '街道详情',
  com                 VARCHAR(20)        NOT NULL
  COMMENT '快递公司代码',
  company_name        VARCHAR(100)       NOT NULL
  COMMENT '快递公司名称',
  is_printed          TINYINT(1)         DEFAULT 0
  COMMENT '是否已打印',
  is_send             TINYINT(1)         DEFAULT 0
  COMMENT '是否发货',
  remarks             VARCHAR(500) COMMENT '備註'
);

-- 商品表
DROP TABLE IF EXISTS goods;
CREATE TABLE goods (
  id         BIGINT PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键',
  goods_name VARCHAR(50) NOT NULL
  COMMENT '商品名称',
  remarks    VARCHAR(200) COMMENT '备注'
);

-- 商品规格表
DROP TABLE IF EXISTS goods_spec;
CREATE TABLE goods_spec (
  id              BIGINT PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键',
  goods_spec_name VARCHAR(50) NOT NULL
  COMMENT '规格名称',
  remarks         VARCHAR(200) COMMENT '备注'
);

-- 快递单号表
DROP TABLE IF EXISTS express_code;
CREATE TABLE express_code (
  id    BIGINT PRIMARY KEY          AUTO_INCREMENT
  COMMENT '主键',
  code  VARCHAR(30) UNIQUE NOT NULL
  COMMENT '快递单号',
  com   VARCHAR(50)        NOT NULL
  COMMENT '快递公司',
  state TINYINT            NOT NULL DEFAULT 0
  COMMENT '是否使用'
);

-- 物流信息表
DROP TABLE IF EXISTS logistics;
CREATE TABLE logistics (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键',
  context     LONGTEXT      NOT NULL
  COMMENT '物流信息',
  order_id    BIGINT UNIQUE NOT NULL
  COMMENT '订单ID',
  is_finished TINYINT(1)         DEFAULT 0
  COMMENT '是否已签收',
  update_at   DATETIME           DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间'
);

-- 快递公司表
DROP TABLE IF EXISTS express_company;
CREATE TABLE express_company (
  id     BIGINT PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键',
  code   VARCHAR(50) UNIQUE NOT NULL
  COMMENT '快递公司代号',
  `name` VARCHAR(100)       NOT NULL
  COMMENT '快递公司名称'
);
INSERT INTO `express_company` (`id`, `code`, `name`)
VALUES
  (1, 'yuantong', '圆通快递'),
  (2, 'zhongtong', '中通快递'),
  (3, 'yunda', '韵达快递'),
  (4, 'shentong', '申通快递'),
  (5, 'annengwuliu', '安能物流'),
  (6, 'yzguonei', '邮政小包');