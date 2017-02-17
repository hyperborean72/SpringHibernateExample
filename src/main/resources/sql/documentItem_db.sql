CREATE TABLE INFOBIP.DOCUMENT_ITEM(
    id INT NOT NULL auto_increment,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    doc_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT item_document FOREIGN KEY (doc_id) REFERENCES DOCUMENT (id) ON UPDATE CASCADE ON DELETE CASCADE
);