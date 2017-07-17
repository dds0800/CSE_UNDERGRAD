library verilog;
use verilog.vl_types.all;
entity AdderSubtractor is
    port(
        S0              : out    vl_logic;
        A0              : in     vl_logic;
        B0              : in     vl_logic;
        C0              : in     vl_logic;
        S1              : out    vl_logic;
        A1              : in     vl_logic;
        B1              : in     vl_logic;
        S2              : out    vl_logic;
        A2              : in     vl_logic;
        B2              : in     vl_logic;
        C4              : out    vl_logic;
        A3              : in     vl_logic;
        B3              : in     vl_logic;
        S3              : out    vl_logic
    );
end AdderSubtractor;
