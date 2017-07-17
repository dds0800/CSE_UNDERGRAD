/*This is a controller that implements
 *INC, CLR, LDA, STA, ADD, and JMP instructions*/
 
module controller(Clock,I3,I2,I1,I0,S,state);
	
	input Clock, I3, I2, I1, I0;
	output reg [11:0]S;
	output reg [3:0]state;
	reg[3:0]nextstate,instruction;
   parameter A = 4'b0000, B = 4'b0001, C = 4'b0010, D = 4'b0011, E = 4'b0100, F = 4'b0101, G = 4'b0110, 
	H = 4'b0111, I = 4'b1000, J = 4'b1001, K = 4'b1010, L = 4'b1011, M = 4'b1100, N = 4'b1101, O = 4'b1110, P = 4'b1111; 
	
	always @ (posedge Clock)
	begin
		state <= nextstate;
	end
	
	always @ (I3,I2,I1,I0)
	begin
		case({I3,I2,I1,I0})
			4'b0000: instruction <= H; //LDA
			4'b0001: instruction <= L; //STA
			4'b0010: instruction <= O; //ADD
			4'b0110: instruction <= F; //INC
			4'b0111: instruction <= G; //CLR
			4'b1000: instruction <= P; //JMP
		endcase
	end
			
		
	always @ (state)
	begin
		case(state)
			4'b0000:begin nextstate <= B; S = 12'b100000010000; end //A
			4'b0001:begin nextstate <= C; S = 12'b010000000000; end //B
			4'b0010:begin nextstate <= D; S = 12'b001000000000; end //C
			4'b0011:begin nextstate <= E; S = 12'b000100000000; end //D
			4'b0100:begin nextstate <= instruction; S = 12'b000011000000; end //E
			4'b0101:begin nextstate <= B; S = 12'b000000100000; end //F
			4'b0110:begin nextstate <= B; S = 12'b000000010000; end //G
			4'b0111:begin nextstate <= I; end //H
			4'b1000:begin nextstate <= J; S = 12'b001000000000; end //I
			4'b1001:begin nextstate <= K; S = 12'b000100000000; end //J
			4'b1010:begin nextstate <= B; S = 12'b000000001100; end //K
			4'b1011:begin nextstate <= M; end //L
			4'b1100:begin nextstate <= N; S = 12'b001000000010; end //M
			4'b1101:begin nextstate <= B; S = 12'b000100000010; end //N
			4'b1110:begin nextstate <= B; end //O
			4'b1111:begin nextstate <= B; S = 12'b000000000001; end //P
			endcase
		end
endmodule
