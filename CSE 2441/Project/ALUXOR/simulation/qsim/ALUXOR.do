onerror {quit -f}
vlib work
vlog -work work ALUXOR.vo
vlog -work work ALUXOR.vt
vsim -novopt -c -t 1ps -L cycloneii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.ALUXOR_vlg_vec_tst
vcd file -direction ALUXOR.msim.vcd
vcd add -internal ALUXOR_vlg_vec_tst/*
vcd add -internal ALUXOR_vlg_vec_tst/i1/*
add wave /*
run -all
