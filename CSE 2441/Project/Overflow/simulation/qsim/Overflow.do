onerror {quit -f}
vlib work
vlog -work work Overflow.vo
vlog -work work Overflow.vt
vsim -novopt -c -t 1ps -L cycloneii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.Overflow_vlg_vec_tst
vcd file -direction Overflow.msim.vcd
vcd add -internal Overflow_vlg_vec_tst/*
vcd add -internal Overflow_vlg_vec_tst/i1/*
add wave /*
run -all
