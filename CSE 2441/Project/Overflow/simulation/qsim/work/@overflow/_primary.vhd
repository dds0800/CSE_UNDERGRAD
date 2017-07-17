library verilog;
use verilog.vl_types.all;
entity Overflow is
    port(
        OVER            : out    vl_logic;
        A3              : in     vl_logic;
        B3              : in     vl_logic;
        S3              : in     vl_logic
    );
end Overflow;
