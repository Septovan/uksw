PROGRAM LatihanChoice2;
USES CRT;

(*
var urutanHari : integer;
var hari : string;
*)

var nilai : integer;

BEGIN
        clrscr;

        (*
        write('Masukkan urutan hari: '); readln(urutanHari);
        *)

        write('Masukkan nilai: '); readln(nilai);

        (*
        case (urutanHari) of
                1 : hari:='SENIN';
                2 : hari:='SELASA';
                3 : hari:='RABU';
                4 : hari:='KAMIS';
                5 : hari:='JUMAT';
                6 : hari:='SABTU';
                7 : hari:='MINGGU';
                else
                  begin
                    hari:='TIDAK ADA HARI';
                  end;
        end;
        *)

        case (nilai) of
               0..40 : writeln('E');
               41..50 : writeln('D');
               51..70 : writeln('C');
               71..84 : writeln('B');
               85..100 : writeln('A');
               else
                 begin
                   writeln('DT');
                 end;
        end;

        (*
        writeln('urutan hari ke-', urutanHari, ' adalah hari ', hari);
        *)

        readkey;
END.