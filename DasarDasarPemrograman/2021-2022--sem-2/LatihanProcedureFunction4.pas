PROGRAM LatihanProcedureFunction4;
USES CRT;

var jumlahTahunLahir, tahunLahir, umur : integer;

FUNCTION hitungUmur(thnLahir:integer) : integer;
const tahunIni = 2022;
BEGIN
  hitungUmur := tahunIni - tahunLahir;
END;

{PROGRAM UTAMA}
BEGIN
  clrscr;

  write('Masukkan jumlah tahun lahir yang diinginkan: ');
  readln(jumlahTahunLahir); writeln();

  REPEAT
    write('MAsukkan tahun lahir: ');readln(tahunLahir);
    umur := hitungUmur(tahunLahir);
    writeln('Umur: ', umur);

    jumlahTahunLahir := jumlahTahunLahir - 1;
  UNTIL jumlahTahunLahir = 0;

  readkey;
END.