create table kelas_seat (
    id VARCHAR(36) PRIMARY KEY,
    kode VARCHAR(255) NOT NULL UNIQUE,
    nama VARCHAR(255) NOT NULL
) Engine=InnoDB ;

create table kereta (
    id VARCHAR(36) PRIMARY KEY,
    kode VARCHAR(255) NOT NULL UNIQUE,
    nama VARCHAR(255)
) Engine=InnoDB ;

create table seat_tersedia (
    id VARCHAR(36) PRIMARY KEY,
    id_kelas VARCHAR(36) NOT NULL,
    id_kereta VARCHAR(36) NOT NULL,
    jumlah INT NOT NULL,
    FOREIGN KEY (id_kelas) REFERENCES kelas_seat(id),
    FOREIGN KEY (id_kereta) REFERENCES kereta(id)
) Engine = InnoDB ;

create table booking (
    id VARCHAR(36) PRIMARY KEY,
    waktu_booking DATETIME NOT NULL,
    waktu_kadaluarsa DATETIME NOT NULL,
    nama_customer VARCHAR(255) NOT NULL,
    jumlah INT NOT NULL,
    status VARCHAR(10) NOT NULL,
    id_kereta VARCHAR(36) NOT NULL,
    id_kelas VARCHAR(36) NOT NULL,
    FOREIGN KEY (id_kelas) REFERENCES kelas_seat(id),
    FOREIGN KEY (id_kereta) REFERENCES kereta(id)
) Engine=InnoDB;
