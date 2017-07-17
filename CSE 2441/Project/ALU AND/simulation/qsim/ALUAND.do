onerror {quit -f}
vlib work
vlog -work work ALUAND.vo
vlog -work work ALUAND.vt
vsim -novopt -c -t 1ps -L cycloneii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.ALUAND_vlg_vec_tst
vcd file -direction ALUAND.msim.vcd
vcd add -internal ALUAND_vlg_vec_tst/*
vcd add -internal ALUAND_vlg_vec_tst/i1/*
add wave /*
run -all
