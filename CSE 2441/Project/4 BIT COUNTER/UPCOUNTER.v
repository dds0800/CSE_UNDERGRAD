//This is a four bit binary up counter

module Counter(Count,Clear,Load,Clock,A,B,C,D);

	input Clear, Clock, A, B, C, D, Load;
	output reg [3:0]Count;
	
	always @ (negedge Clock, negedge Clear, negedge Load)
		if(Clear == 0) Count <= 4'b0;
		else if(Load == 0) Count <= {A,B,C,D};
		else
			begin
					if(Count == 4'b1111) 
						Count <= 4'b0;
					else 
						Count <= Count + 1'b1;
			end
endmodule
