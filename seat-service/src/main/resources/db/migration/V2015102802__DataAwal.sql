insert into kelas_seat (id, kode, nama) values 
('exec', 'Eksekutif', 'Kelas Eksekutif');
insert into kelas_seat (id, kode, nama) values 
('bisnis', 'Bisnis', 'Kelas Bisnis');
insert into kelas_seat (id, kode, nama) values 
('eko', 'Ekonomi', 'Kelas Ekonomi');


insert into kereta (id, kode, nama) values 
('aa', 'AB-001', 'Argo Bromo Anggrek');
insert into kereta (id, kode, nama) values 
('ab', 'GM-001', 'Gumarang');

insert into seat_tersedia(id, id_kelas, id_kereta, jumlah) values
('aaex', 'exec', 'aa', 100);
insert into seat_tersedia(id, id_kelas, id_kereta, jumlah) values
('aab', 'bisnis', 'aa', 200);
insert into seat_tersedia(id, id_kelas, id_kereta, jumlah) values
('aaek', 'eko', 'aa', 0);

insert into seat_tersedia(id, id_kelas, id_kereta, jumlah) values
('abex', 'exec', 'ab', 30);
insert into seat_tersedia(id, id_kelas, id_kereta, jumlah) values
('abb', 'bisnis', 'ab', 500);
insert into seat_tersedia(id, id_kelas, id_kereta, jumlah) values
('abek', 'eko', 'ab', 150);
