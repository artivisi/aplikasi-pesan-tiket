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

insert into s_users (id, username, password, aktif) values
('e', 'endy', '123', true);
insert into s_users (id, username, password, aktif) values
('d', 'dadang', '123', true);

insert into s_permission (id, nama) values 
('vk', 'ROLE_VIEW_KERETA');
insert into s_permission (id, nama) values 
('vs', 'ROLE_VIEW_SEAT');
insert into s_permission (id, nama) values 
('cb', 'ROLE_CREATE_BOOKING');

insert into s_user_permission(id_user, id_permission) values 
('e','vk');
insert into s_user_permission(id_user, id_permission) values
('e','vs');
insert into s_user_permission(id_user, id_permission) values
('d','vs');
insert into s_user_permission(id_user, id_permission) values
('d','cb');

