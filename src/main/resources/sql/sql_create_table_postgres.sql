CREATE TABLE fpf_origem
(
  orig_id integer not null,
  orig_dsorigem varchar(60)
);

ALTER TABLE ONLY fpf_origem
    ADD CONSTRAINT xxk1_origem PRIMARY KEY (orig_id);


CREATE TABLE fpf_categoria
(
  cate_id integer not null,
  cate_dscategoria varchar(60)
);


ALTER TABLE ONLY fpf_categoria
    ADD CONSTRAINT xxk1_categoria PRIMARY KEY (cate_id);

 CREATE TABLE fpf_produto
 (
   prod_id integer not null,
   prod_dsproduto varchar(60),
   prod_dtcompra timestamp without time zone,
   prod_vlpreco float,
   orig_id integer,
   cate_id integer
 );  


ALTER TABLE ONLY fpf_produto
    ADD CONSTRAINT xxk1_produto PRIMARY KEY (prod_id);


ALTER TABLE ONLY fpf_produto
    ADD CONSTRAINT xfk1_produto FOREIGN KEY (orig_id) REFERENCES fpf_origem(orig_id);   

ALTER TABLE ONLY fpf_produto
    ADD CONSTRAINT xfk2_produto FOREIGN KEY (cate_id) REFERENCES fpf_categoria(cate_id);        


CREATE SEQUENCE fpf_origem_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE fpf_categoria_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE fpf_produto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;    

ALTER SEQUENCE fpf_origem_seq OWNED BY fpf_origem.orig_id;    
ALTER SEQUENCE fpf_categoria_seq OWNED BY fpf_categoria.cate_id;        
ALTER SEQUENCE fpf_produto_seq OWNED BY fpf_produto.prod_id;       

ALTER TABLE ONLY fpf_origem ALTER COLUMN orig_id SET DEFAULT nextval('fpf_origem_seq'::regclass);
ALTER TABLE ONLY fpf_categoria ALTER COLUMN cate_id SET DEFAULT nextval('fpf_categoria_seq'::regclass);
ALTER TABLE ONLY fpf_produto ALTER COLUMN prod_id SET DEFAULT nextval('fpf_produto_seq'::regclass);



    