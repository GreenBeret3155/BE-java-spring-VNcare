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

GET/tinh/{tinhid}/cosoyte

POST/tinh/{tinhid}/cosoyte

PUT/cosoyte/{cosoyteid}

PUT/tinh/{tinhid}/cosoyte/{cosoyteid}

DELETE/cosoyte/{id}
### /khoa
GET/khoa

GET/khoa/{id}

GET/cosoyte/{cosoyteid}/khoa

POST/cosoyte/{cosoyteid}/khoa

PUT/khoa/{khoaid}

PUT/cosoyte/{cosoyteid}/khoa/{khoaid}

DELETE/khoa/{id}
### /bacsi
GET/bacsi

GET/bacsi/{id}

GET/khoa/{khoaid}/bacsi

GET/taikhoan/{taikhoanid}/bacsi

POST/khoa/{khoaid}/taikhoan/{taikhoanid}/bacsi

PUT/bacsi/{bacsiid}

PUT/khoa/{khoaid}/bacsi/{bacsiid}

DELETE/bacsi/{id}

DELETE/bacsi/{id}	
### /benhnhan
GET/benhnhan

GET/benhnhan/{id}

GET/taikhoan/{taikhoanid}/benhnhan

POST/taikhoan/{taikhoanid}/benhnhan

POST/benhnhan

PUT/benhnhan/{id}

DELETE/benhnhan/{id}
### /quanhe
GET/quanhe

GET/benhnhan/{benhnhanchinhid}/quanhe

POST/benhnhan/{benhnhanchinhid}/{benhnhanphuid}/quanhe

PUT/benhnhan/{benhnhanchinhid}/{benhnhanphuid}/quanhe

DELETE/benhnhan/{benhnhanchinhid}/{benhnhanphuid}/quanhe
### /dangkykham
GET/dangkykham

GET/dangkykham/{id}

GET/benhchinh/{benhchinhid}/dangkykham

GET/bacsi/{bacsiid}/dangkykham

GET/benhnhan/{benhnhanid}/dangkykham

POST/benhnhan/{benhnhanid}/bacsi/{bacsiid}/benhchinh/{benhchinhid}/dangkykham	

POST/benhnhan/{benhnhanid}/bacsi/{bacsiid}/dangkykham

PUT/benhnhan/{benhnhanid}/bacsi/{bacsiid}/benhchinh/{benhchinhid}/dangkykham/{id}

PUT/benhnhan/{benhnhanid}/bacsi/{bacsiid}/dangkykham/{id}

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

GET/dangkykham/{dangkykhamid}/donthuoc

POST/dangkykham/{dangkykhamid}/thuoc/{thuocid}/donvitinh/{donvitinhid}/donthuoc

PUT/dangkykham/{dangkykhamid}/thuoc/{thuocid}/donvitinh/{donvitinhid}/donthuoc/{id}

DELETE/donthuoc/{id}

DELETE/dangkykham/{dangkykhamid}/donthuoc
