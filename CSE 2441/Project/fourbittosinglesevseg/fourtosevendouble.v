//Four bit binary to a single seven segment display

module binarytodoubleseven(
input w,x,y,z, 
output reg [6:0] S,
output reg [6:0] R);

always @ (w,x,y,z)
	begin
		case({w,x,y,z})
			4'b0000: begin S = 7'b0000001; R = 7'b0000001; end
			4'b0001: begin S = 7'b1001111; R = 7'b0000001; end
			4'b0010: begin S = 7'b0010010; R = 7'b0000001; end
			4'b0011: begin S = 7'b0000110; R = 7'b0000001; end
			4'b0100: begin S = 7'b1001100; R = 7'b0000001; end
			4'b0101: begin S = 7'b0100100; R = 7'b0000001; end
			4'b0110: begin S = 7'b0100000; R = 7'b0000001; end
			4'b0111: begin S = 7'b0001111; R = 7'b0000001; end
			4'b1000: begin S = 7'b0000000; R = 7'b0000001; end
			4'b1001: begin S = 7'b0001100; R = 7'b0000001; end
			4'b1010: begin S = 7'b0000001; R = 7'b1001111; end
			4'b1011: begin S = 7'b1001111; R = 7'b1001111; end
			4'b1100: begin S = 7'b0010010; R = 7'b1001111; end
			4'b1101: begin S = 7'b0000110; R = 7'b1001111; end
			4'b1110: begin S = 7'b1001100; R = 7'b1001111; end
			4'b1111: begin S = 7'b0100100; R = 7'b1001111; end
		endcase
	end
endmodule
