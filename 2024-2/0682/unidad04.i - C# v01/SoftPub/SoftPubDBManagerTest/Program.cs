using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubDBManager;
using MySql.Data.MySqlClient;

namespace SoftPubDBManagerTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            System.Console.WriteLine("DBManagerTest");
            //la siguiente línea de código no se puede hacer pues el constructor es privado
            //de esta forma se comporta el Singleton
            //DBManager dbManager = new DBManager();
            DBManager dbManager = null;
            System.Console.WriteLine(dbManager);

            dbManager = DBManager.Instance;
            System.Console.WriteLine(dbManager);

            dbManager = DBManager.Instance;
            System.Console.WriteLine(dbManager);

            dbManager = DBManager.Instance;
            System.Console.WriteLine(dbManager);

            MySqlConnection conexion = dbManager.Conexion;
            conexion.Open();
            conexion.Close();

            System.Console.ReadLine();
        }
    }
}
