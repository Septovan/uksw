PROGRAM LatihanProcedureFunction2;

USES CRT;

PROCEDURE cetakBintang(jumlahBintang:integer);
var i : integer;
BEGIN
  FOR i := 0 TO jumlahBintang DO
    BEGIN
      write('*');
    END;
END;

PROCEDURE cetakSpasi(jumlahSpasi:integer);
var i : integer;
BEGIN
  FOR i := 0 TO jumlahSpasi DO
    BEGIN
      write(' ');
    END;
END;

{PROGRAM UTAMA}
BEGIN
  clrscr;

  cetakBintang(1); cetakSpasi(1); cetakBintang(1); writeln();
  cetakSpasi(1); cetakBintang(1); writeln();
  cetakBintang(1); cetakSpasi(1); cetakBintang(1);

  readkey;
END.