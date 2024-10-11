using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Text.Json;
using System.IO;

namespace SoftPubDBManager
{
    public class DBManager
    {
        public class Mysql_json
        {
            public string base_de_datos { get; set; }
            public string nombre_de_host { get; set; }
            public string puerto { get; set; }
            public string usuario { get; set; }
            public string contraseña { get; set; }
        }

        private static string ARCHIVO_CONFIGURACION = "../../../base_de_datos.json";

        private MySqlConnection conexion;        
        private string base_de_datos;
        private string nombre_de_host;
        private string puerto;
        private string usuario;
        private string contraseña;
        private static DBManager dbManager;

        private DBManager()
        {
            //para que no se pueda crear instancias fuera de la clase
        }

        public static DBManager Instance
        {
            get
            {
                if (dbManager == null)
                {
                    createInstance();
                }
                return dbManager;
            }
        }

        private static void createInstance()
        {
            if (dbManager == null)
            {
                dbManager = new DBManager();
            }
        }

        public MySqlConnection Connection
        {
            get
            {
                this.leer_archivo_de_configuracion();
                string cadena_de_conexion = this.obtener_cadena_de_conexion();     
                System.Console.WriteLine(cadena_de_conexion);
                this.conexion = new MySqlConnection(cadena_de_conexion);
                return this.conexion;
            }
        }

        private void leer_archivo_de_configuracion()
        {
            string cadena_json = File.ReadAllText(ARCHIVO_CONFIGURACION);
            Mysql_json mysql_json = JsonSerializer.Deserialize<Mysql_json>(cadena_json);
            this.nombre_de_host = mysql_json.nombre_de_host;
            this.usuario = mysql_json.usuario;
            this.contraseña = mysql_json.contraseña;
            this.base_de_datos = mysql_json.base_de_datos;
            this.puerto = mysql_json.puerto;
        }

        private string obtener_cadena_de_conexion()
        {
            string cadena_de_conexion = "server=" + this.nombre_de_host + ";";
            cadena_de_conexion += "user=" + this.usuario + ";";
            cadena_de_conexion += "password=" + this.contraseña + ";";
            cadena_de_conexion += "port=" + this.puerto + ";";
            cadena_de_conexion += "database=" + this.base_de_datos + ";";
            return cadena_de_conexion;
        }
    }
}
