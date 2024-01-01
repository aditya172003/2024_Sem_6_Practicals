import java.util.*;
import java.util.Collection.*;


class Graph
{
       private List<List<Integer>>adj_ist;
       
       private int nodes;
       private List<Boolean>visited;
       public Graph()
       {
            adj_ist = new ArrayList<>();
            nodes   = 0;
            visited = new ArrayList<>();
             for(int i =0;i<=nodes;i++)
            {
                visited.add(false);
            }
           
            
       }
       public Graph(int nodes)
       {
            adj_ist = new ArrayList<>();

            for(int i =0;i<=nodes;i++)
            {
                adj_ist.add( new ArrayList<>());
            }
            this.nodes = nodes;
            visited = new ArrayList<>();
            for(int i =0;i<=nodes;i++)
            {
                visited.add(false);
            }
           
       }

       public void scanGraph()
       {
            System.out.println("Enter the connected nodes ");
            Scanner sc = new Scanner(System.in);
            int maxEdges = nodes*(nodes-1)/2;
            System.out.println("Is the graph bidirectional? (yes/no)");
            String isbidirectional = sc.next();
            while(--maxEdges >0)
            {
                int u,v;
                System.out.println("Enter the nodes u and v / to end enter -1");
                u = sc.nextInt();
                if(u==-1)
                {
                    return;
                }
                v = sc.nextInt();
                if(u<0 || u>nodes || v<0 || v>nodes)
                {
                    System.out.println("Please enter node numbers in range "+1+" to "+nodes);
                    maxEdges++;
                    continue;
                }
                adj_ist.get(u).add(v);
                if(isbidirectional.toLowerCase().equals("yes"))
                {
                      adj_ist.get(v).add(u);
                }
                
            }
       }


       public void dfs_Recursive(int node)
       {
            visited.set(node, true);

            System.out.print(node+" -> ");

            for(var nbr : adj_ist.get(node))
            {
                if(visited.get(nbr)==false)
                {
                    
                    dfs_Recursive(nbr);
                }
            }

       }
 
    private void bfsInternal(Vector<Integer>visit,int node)
    {
            Queue<Integer>q = new LinkedList<>();
            q.add(node);
             visit.set(node, 1);
            while(!q.isEmpty())
            {
                node = q.poll();
                System.out.print(node +" ");
           
                for(var n : adj_ist.get(node))
                {
                    if(visit.get(n)!=1)
                    {
                        visit.set(n, 1);
                        q.add(n);
                    }
                }

            }
    }       


    public void bfs()
    {
        Vector<Integer> visit = new Vector<>();
        for(int i =0;i<=nodes;i++)
        {
            visit.add( 0);
        }

          for(int i =1;i<=nodes;i++)
        {
           if(visit.get(i)==0)
           {
             bfsInternal(visit, i);
           }
        }
    }

}




public class Assignment_1
{
    public static void main(String[] args) {
        System.out.println("Assignment 1 ");

        Graph g  = new Graph(5);
        g.scanGraph();

        System.out.println("==== DFS =====");

        g.dfs_Recursive(1);

        System.out.println();

        System.out.println("==== BFS ====");

        g.bfs();
        System.out.println();
    }
}