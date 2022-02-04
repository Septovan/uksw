PROGRAM LatihanProcedureFunction1;

USES CRT;

PROCEDURE cetak3Bintang;
BEGIN
  write('***');
END;

PROCEDURE cetak3Spasi;
BEGIN
  write('   ');
END;


{PROGRAM UTAMA}
BEGIN
  clrscr;

  cetak3Bintang(); cetak3Spasi(); cetak3Bintang; writeln();
  cetak3Spasi(); cetak3Bintang(); writeln();
  cetak3Bintang(); cetak3Spasi(); cetak3Bintang();

  readkey;
END.