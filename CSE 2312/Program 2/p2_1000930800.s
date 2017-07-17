/* 
 * Daniel Singh
 * Program 2
 * Dr. McMurrough
 * CSE 2312
 */
 
    .global main
    .func main
    
main:
    BL _scanf
    MOV R1, R0
    BL _scanf
    MOV R2, R0
    MOV R7, R1
    MOV R8, R2
    BL count_partitions
    MOV R4, R0
    BL _printf
    B main
    
    
    
_scanf:
    PUSH {LR}               @ store LR since scanf call overwrites
    PUSH {R1}               @ R1 will be used in this procedure
    SUB SP, SP, #4          @ make room on stack
    LDR R0, =format_str     @ R0 contains address of format string
    MOV R1, SP              @ move SP to R1 to store entry on stack
    BL scanf                @ call scanf
    LDR R0, [SP]            @ load value at SP into R0
    ADD SP, SP, #4          @ restore the stack pointer
    POP {R1}                @ Return proper value into R1
    POP {PC}                @ return
    
_printf:
    PUSH {LR}           @ store LR since printf call overwrites
    LDR R0,=print_str   @ R0 contains formatted string address
    MOV R1, R4          @ printf argument 1
    MOV R2, R7          @ printf argument 2
    MOV R3, R8          @ printf argument 3
    BL printf           @ call printf
    POP {PC}            @ return
    
count_partitions:
    PUSH {LR}
    CMP R1, #0
    MOVEQ R0, #1         @ If R1==0 return 1
    POPEQ {PC}
    MOVLT R0, #0         @ If R1<0 return 0
    POPLT {PC}
    CMP R2, #0
    MOVEQ R0, #0         @ If R2==0 return 0
    POPEQ {PC}
    
    PUSH {R1}            @ begin recursive case 
    PUSH {R2}            @ store R1 and R2 for later use
    SUB R1, R1, R2       @ Compute n-m
    BL count_partitions  @ Recursive procedure call count_partition(n-m,m)
    MOV R4, R0           @ Computed value for count_partitions is in R0. Move return value to R4 for later use
    POP {R2}
    POP {R1}             @ Original values for R1 and R2 no longer need to be saved
    PUSH {R4}
    SUB R2, R2, #1       @ Compute m-1
    BL count_partitions  @ Recursive procedure call count_partitions(n,m-1)
    MOV R5, R0           @ Computed value for count_partitions is in R0. Move return value to R5 for later use
    POP {R4}
    ADD R0, R4, R5       @ Compute final value and return
    POP {PC}
    
    
.data
format_str:     .asciz      "%d"
print_str:      .asciz      "There are %d partitions of %d using integers up to %d \n"
