using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SofPubDBManager;
using MySql.Data.MySqlClient;

namespace SoftPubDBManagerTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            System.Console.WriteLine("DBManagerTest");
            // la siguiente línea no funciona pues es un Singleton (constructor sin parámetros privado)
            //DBManager dbManager = new DBManager();
            DBManager dbManager = DBManager.Instance;
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
