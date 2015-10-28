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
    jumlah INT
) Engine = InnoDB ;
