PROGRAM Latihan2;

USES CRT;

var
  nama : string;
  tahunLahir, umur : integer;

const tahunIni = 2022;

BEGIN
  clrscr;

  write('Nama: '); readln(nama);
  write('Tahun lahir: '); readln(tahunLahir);

  writeln('=========================');

  umur := tahunIni - tahunLahir;

  writeln('Nama: ', nama);
  writeln('Umur: ', umur);

  readkey;
END.