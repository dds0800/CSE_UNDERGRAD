/*
* Daniel Singh Program 1
* CSE 2312 Dr. McMurrough
*/

		.global main
		.func main

main:
    BL  _scanf              @ branch to scanf procedure with return
	MOV R9, R0		@move first operand into R9
	BL _getchar
	MOV R10, R0	@move operation character to R10
	BL  _scanf		@move second operand to R11
	MOV R11, R0
	BL _compare
	MOV R12, R0	@move computed result into R12
	BL  _print          @ branch to print procedure with return
	B main

_print:
    PUSH {LR}          @ store LR since printf call overwrites
    LDR R0,=print_str   @ R0 contains formatted string address
    MOV R1, R12        @ printf argument
    BL printf           @ call printf
    POP {PC}          @ return

_scanf:
    PUSH {LR}              @ store LR since scanf call overwrites
    SUB SP, SP, #4          @ make room on stack
    LDR R0, =format_str     @ R0 contains address of format string
    MOV R1, SP              @ move SP to R1 to store entry on stack
    BL scanf                @ call scanf
    LDR R0, [SP]            @ load value at SP into R0
    ADD SP, SP, #4          @ restore the stack pointer
    POP {PC}              @ return

_compare:
	PUSH {LR}
	CMP R10, #'+'
	BLEQ SUM
	CMP R10, #'-'
	BLEQ DIFFERENCE
	CMP R10, #'*'
	BLEQ PRODUCT
	CMP R10, #'M'
	BLEQ max
	POP {PC}

_getchar:
    PUSH {LR}
    MOV R7, #3              @ write syscall, 3
    MOV R0, #0              @ input stream from monitor, 0
    MOV R2, #1              @ read a single character
    LDR R1, =read_char      @ store the character in data memory
    SWI 0                   @ execute the system call
    LDR R0, [R1]            @ move the character to the return register
    AND R0, #0xFF           @ mask out all but the lowest 8 bits
    POP {PC}              @ return

SUM:
	PUSH {LR}
	MOV R1, R9
	MOV R2, R11
	ADD R0, R1, R2
        POP {PC}          @ return

DIFFERENCE:
	PUSH {LR}
	MOV R1, R9
	MOV R2, R11
	SUB R0, R1, R2
        POP {PC}          @ return

PRODUCT:
       PUSH {LR}
	MOV R1, R9
	MOV R2, R11
	MUL R0, R1, R2
        POP {PC}          @ return

max:
        PUSH {LR}
	MOV R1, R9
	MOV R2, R11
	CMP R1, R2
	MOVGE R0, R1
	MOVLT R0, R2
        POP {PC}          @ return


.data
	format_str:     .asciz      "%d"
	prompt_str:     .asciz      "Type a number and press enter: "
	read_char:      .ascii      " "
	print_str: 	.asciz "%d\n"
