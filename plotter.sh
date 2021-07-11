gnuplot -persist -e " set term wxt;
                      set title 'google.com RTT'; 
                      set xlabel 'Time (in sec)'; set ylabel 'RTT (in milliseconds)';
                      plot 'google.txt' using 1:2 title \"Sample RTT\" with lines,
                           'google.txt' using 1:3 title \"Estimated RTT\" with lines"
gnuplot -persist -e " set term wxt;
                      set title 'google.com TimeoutInterval'; 
                      set xlabel 'Time (in sec)'; set ylabel 'TimeoutInterval (in milliseconds)';
                      plot 'google.txt' using 1:4 title \"Timeout Interval\" with lines"

gnuplot -persist -e " set term wxt;
                      set title 'facebook.com RTT'; 
                      set xlabel 'Time (in sec)'; set ylabel 'RTT (in milliseconds)';
                      plot 'facebook.txt' using 1:2 title \"Sample RTT\" with lines,
                           'facebook.txt' using 1:3 title \"Estimated RTT\" with lines"
gnuplot -persist -e " set term wxt;
                      set title 'facebook.com TimeoutInterval'; 
                      set xlabel 'Time (in sec)'; set ylabel 'TimeoutInterval (in milliseconds)';
                      plot 'facebook.txt' using 1:4 title \"Timeout Interval\" with lines"

gnuplot -persist -e " set term wxt;
                      set title 'sxc.edu.np RTT'; 
                      set xlabel 'Time (in sec)'; set ylabel 'RTT (in milliseconds)';
                      plot 'sxc.txt' using 1:2 title \"Sample RTT\" with lines,
                           'sxc.txt' using 1:3 title \"Estimated RTT\" with lines"
gnuplot -persist -e " set term wxt;
                      set title 'sxc.edu.np TimeoutInterval'; 
                      set xlabel 'Time (in sec)'; set ylabel 'TimeoutInterval (in milliseconds)';
                      plot 'sxc.txt' using 1:4 title \"Timeout Interval\" with lines"

gnuplot -persist -e " set term wxt;
                      set title 'youku.com RTT'; 
                      set xlabel 'Time (in sec)'; set ylabel 'RTT (in milliseconds)';
                      plot 'youku.txt' using 1:2 title \"Sample RTT\" with lines,
                           'youku.txt' using 1:3 title \"Estimated RTT\" with lines"
gnuplot -persist -e " set term wxt;
                      set title 'youku.com TimeoutInterval'; 
                      set xlabel 'Time (in sec)'; set ylabel 'TimeoutInterval (in milliseconds)';
                      plot 'youku.txt' using 1:4 title \"Timeout Interval\" with lines"

gnuplot -persist -e " set term wxt;
                      set title 'bonjourdefrance.co.uk RTT'; 
                      set xlabel 'Time (in sec)'; set ylabel 'RTT (in milliseconds)';
                      plot 'bonjourdefrance.txt' using 1:2 title \"Sample RTT\" with lines,
                           'bonjourdefrance.txt' using 1:3 title \"Estimated RTT\" with lines"
gnuplot -persist -e " set term wxt;
                      set title 'bonjourdefrance.co.uk TimeoutInterval'; 
                      set xlabel 'Time (in sec)'; set ylabel 'TimeoutInterval (in milliseconds)';
                      plot 'bonjourdefrance.txt' using 1:4 title \"Timeout Interval\" with lines"


