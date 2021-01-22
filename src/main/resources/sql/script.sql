CREATE OR REPLACE FUNCTION public.bytea_import(
	p_path text,
	OUT p_result bytea)
    RETURNS bytea
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
declare
  l_oid oid;
begin
  select lo_import(p_path) into l_oid;
  select lo_get(l_oid) INTO p_result;
  perform lo_unlink(l_oid);
end;
$BODY$;

ALTER FUNCTION public.bytea_import(text)
    OWNER TO postgres;
