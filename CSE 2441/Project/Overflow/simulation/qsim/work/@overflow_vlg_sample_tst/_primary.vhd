library verilog;
use verilog.vl_types.all;
entity Overflow_vlg_sample_tst is
    port(
        A3              : in     vl_logic;
        B3              : in     vl_logic;
        S3              : in     vl_logic;
        sampler_tx      : out    vl_logic
    );
end Overflow_vlg_sample_tst;
