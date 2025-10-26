-- V2: Migration para adicionar a coluna de rank na tabela de ninjas

ALTER TABLE tb_ninjas
ADD COLUMN rank VARCHAR(255);