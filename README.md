# BE-java-spring-VNcare
## /api
### /taikhoan
GET/taikhoan

GET/taikhoan/{id}

POST/taikhoan

PUT/taikhoan/{id}

DELETE/taikhoan/{id}

### /tinh
GET/tinh

GET/tinh/{id}

POST/tinh

PUT/tinh/{id}

DELETE/tinh/{id}

### /cosoyte
GET/cosoyte

GET/cosoyte/{id}

GET/cosoyte/tinh/{tinhid}

POST/cosoyte/tinh/{tinhid}

PUT/cosoyte/{cosoyteid}/tinh/{tinhid}

DELETE/cosoyte/{id}
### /khoa
GET/khoa

GET/khoa/{id}

GET/khoa/cosoyte/{cosoyteid}

POST/khoa/cosoyte/{cosoyteid}

PUT/khoa/{khoaid}/cosoyte/{cosoyteid}

DELETE/khoa/{id}

### /bacsi
GET/bacsi

GET/bacsi/{id}

GET/bacsi/khoa/{khoaid}

GET/bacsi/khoa/{taikhoanid}

POST/bacsi/khoa/{khoaid}/taikhoan/{taikhoanid}

PUT/bacsi/{bacsiid}/khoa/{khoaid}/taikhoan/{taikhoanid}

DELETE/bacsi/{id}	
### /benhnhan
GET/benhnhan

GET/benhnhan/{id}

GET/benhnhan/taikhoan/{taikhoanid}

POST/benhnhan/taikhoan/{taikhoanid}

POST/benhnhan

PUT/benhnhan/{id}/taikhoan/{taikhoanid}

PUT/benhnhan/{id}

DELETE/benhnhan/{id}
### /quanhe
GET/quanhe

GET/quanhe/benhnhan/{benhnhanchinhid}

POST/quanhe/benhnhan/{benhnhanchinhid}/{benhnhanphuid}

PUT/quanhe/benhnhan/{benhnhanchinhid}/{benhnhanphuid}

DELETE/quanhe/benhnhan/{benhnhanchinhid}/{benhnhanphuid}
### /dangkykham
GET/dangkykham

GET/dangkykham/{id}

GET/dangkykham/benhchinh/{benhchinhid}

GET/dangkykham/bacsi/{bacsiid}

GET/dangkykham/benhnhan/{benhnhanid}

POST/dangkykham/benhnhan/{benhnhanid}/bacsi/{bacsiid}/benhchinh/{benhchinhid}	

POST/dangkykham/benhnhan/{benhnhanid}/bacsi/{bacsiid}

PUT/dangkykham/{id}/benhnhan/{benhnhanid}/bacsi/{bacsiid}/benhchinh/{benhchinhid}

PUT/dangkykham/{id}/benhnhan/{benhnhanid}/bacsi/{bacsiid}

DELETE/dangkykham/{id}
### /benh
GET/benh

GET/benh/{id}

GET/benh/{id}

POST/benh

PUT/benh/{id}

DELETE/benh/{id}
### /thuoc
GET/thuoc

GET/thuoc/{id}

POST/thuoc

PUT/thuoc/{id}

DELETE/thuoc/{id}
### /donvitinh
GET/donvitinh

GET/donvitinh/{id}

POST/donvitinh

PUT/donvitinh/{id}

DELETE/donvitinh/{id}
### /donthuoc
GET/donthuoc

GET/donthuoc/{id}

GET/donthuoc/dangkykham/{dangkykhamid}

POST/donthuoc/dangkykham/{dangkykhamid}/thuoc/{thuocid}/donvitinh/{donvitinhid}

PUT/donthuoc/{id}/dangkykham/{dangkykhamid}/thuoc/{thuocid}/donvitinh/{donvitinhid}

DELETE/donthuoc/dangkykham/{dangkykhamid}
