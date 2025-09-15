package levenshtein;

public class MainLev {
    public static void main(String[] args) {
        String from1 = "Casablanca";
        String to1   = "Portentoso";

        String from2 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
            "simplify the build processes in the Jakarta Turbine project. There were several" + 
   			" projects, each with their own Ant build files, that were all slightly different." +
   			"JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
   			"definition of what the project consisted of, an easy way to publish project information" +
   			"and a way to share JARs across several projects. The result is a tool that can now be" +
   			"used for building and managing any Java-based project. We hope that we have created " +
   			"something that will make the day-to-day work of Java developers easier and generally help " +
   			"with the comprehension of any Java-based project.";
        String to2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
   			"kernels. They are universally applicable in any machine learning algorithm. Why you might" +
   			"ask? I am going to try to answer this question in this article." + 
   		    "Go to the profile of Marin Vlastelica Pogančić" + 
   		    "Marin Vlastelica Pogančić Jun";

        Solves.resetCounters();
        long start = System.currentTimeMillis();
        int distance1 = Solves.bruteforce(from1, to1);
        long end = System.currentTimeMillis();
        System.out.println("-------- bruteforce 1 --------");
        System.out.printf("distance = %d, iterations = %d, instructions = %d, time = %dms\n",
                          distance1, Solves.iterations, Solves.instructions, end - start);

        Solves.resetCounters();

        // trust me you do not want to run this lmao

        // start = System.currentTimeMillis();
        // int distance2 = Solves.bruteforce(from2, to2);
        // end = System.currentTimeMillis();
        // System.out.println("-------- bruteforce 2 --------");
        // System.out.printf("distance = %d, iterations = %d, instructions = %d, time = %dms\n",
        //                   distance2, Solves.iterations, Solves.instructions, end - start);

        Solves.resetCounters();

        start = System.currentTimeMillis();
        int distance3 = Solves.distEdProgDina(from1, to1);
        end = System.currentTimeMillis();
        System.out.println("-------- distEdProgDina 1 --------");
        System.out.printf("distance = %d, iterations = %d, instructions = %d, time = %dms\n",
                          distance3, Solves.iterations, Solves.instructions, end - start);
    }
}
