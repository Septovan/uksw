PROGRAM LatihanProcedureFunction3;
USES CRT;

var a, b, c, minimum : integer;

PROCEDURE findMinimum(x, y, z:integer; var min:integer);
BEGIN
  IF x < y THEN
    BEGIN
      min := x;
    END
  ELSE
    BEGIN
      min := y;
    END;

  IF z < min THEN
    BEGIN
      min := z;
    END;
END;

{PROGRAM UTAMA}
BEGIN
  clrscr;

  writeln('Masukkan 3 angka: ');
  readln(a, b, c);
  findMinimum(a, b, c, minimum);

  writeln('Angka minimum: ', minimum);

  readkey;
END.