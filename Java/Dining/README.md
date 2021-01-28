3.2 Assignment - Florida Institute of Technology - Nimesh Silva - Dr. Bulumulle - CYB 5285

    Create a demonstration of the “Dining Philosophers Problem” in C/C++, Java, or Python (see textbook Section 7.1.3 for details)

3.2 Assignment: Dining Philosophers

This program was written in Java. 
The aim is to create a procedure for 
philosophers to accomplish their goal of 
eating and dreaming without starving to 
death. The philosopher gets hungry after 
some time and wants to feed. 
The philosopher reaches for the forks 
on either side of him to do this. 
Once the philosopher succeeds in getting 
both people, he starts to feed. 
If he puts both forks down, 
his neighbor's philosopher has access to 
those forks. We need to lock it to 
simulate acquiring a fork so that no 
two philosophical threads obtain it at 
the same time. We use the synchronized 
keyword to obtain the fork object's 
internal monitor to accomplish this and 
prevent other threads from doing the same.
This is performed in the process run(). 
For a moment, a philosopher thinks and 
then decides to eat. In order to explain 
the order in which actions occur, 
timestamps have also been applied to each 
operation. As generic Java objects, 
we model each of the forks and render 
as many of them as philosophers exist. 
Using the synchronized keyword, 
we pass each Philosopher his left and 
right forks that he tries to lock. 
Both philosophers, without triggering a 
deadlock, get their chance to 
think and eat. 
We analyzed the popular 
Dining Philosophers problem using threads 
in this paper. My code can be found here 
https://github.com/nimeshsilva1997/JVM-Projects/tree/master/Java/Dining.







Plagiarism

You are expected to write primarily in your
own voice, using paraphrase, summary, 
and synthesis techniques when integrating 
information from class
and outside sources. 
Use an author’s exact words only when the 
language is especially vivid, unique, 
or needed for technical accuracy. 
Failure to do so may result in charges of 
Academic Dishonesty.

Overusing an author’s exact words, 
such as including block quotations to 
meet word counts, may lead your readers 
to conclude that you lack appropriate 
comprehension of the subject matter or 
that you are neither an original thinker 
nor a skillful writer.
