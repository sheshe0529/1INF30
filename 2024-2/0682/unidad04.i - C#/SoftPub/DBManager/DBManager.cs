using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.IO;
using System.Text.Json;

namespace SoftPubDBManager{ 
    public class DBManager
    {
        private static string ARCHIVO_CONFIGURACION = "../../../base_de_datos.json";
        private MySqlConnection conexion;
        private string base_de_datos;
        private string nombre_de_host;
        private string puerto;
        private string usuario;
        private string contraseña;
        private static DBManager dbManager = null;

        private DBManager()
        {
            //se hace el constructor privado para que no se pueda instanciar una objeto de esta clase
        }

        public static DBManager Instance
        { //¿Cómo se utiliza la propiedad? instancia = DBManager.Instance; <- en ese momento se ejecuta el get
            get 
            {
                if (dbManager == null)
                    createInstance();
                return dbManager;
            } 
        }

        private static void createInstance()
        {
            if (dbManager == null)
                dbManager = new DBManager();
        }

        public MySqlConnection Conexion
        { //¿Cómo se utiliza la propiedad? conexion = dBManager.Conexion;
            get
            {
                this.leer_archivo_de_configuracion();
                string cadena_de_conexion = this.obtener_cadena_de_conexion();
                this.conexion = new MySqlConnection(cadena_de_conexion);
                return conexion;
            }
        }

        public class MySQL_json
        {
            public string base_de_datos { get; set; }
            public string nombre_de_host { get; set; }
            public string puerto { get; set; }
            public string usuario { get; set; }
            public string contraseña { get; set; }
        }

        private void leer_archivo_de_configuracion()
        // para usar el soporte a JSON, agregar la referencia a System.Text.Json
        {
            string cadena_json = File.ReadAllText(ARCHIVO_CONFIGURACION); //para que funcione File usar using System.IO            
            MySQL_json mySQL_Json = JsonSerializer.Deserialize<MySQL_json>(cadena_json);
            this.nombre_de_host = mySQL_Json.nombre_de_host;            
            this.usuario = mySQL_Json.usuario;
            this.contraseña = mySQL_Json.contraseña;
            this.base_de_datos = mySQL_Json.base_de_datos;
            this.puerto = mySQL_Json.puerto;
        }

        private string obtener_cadena_de_conexion()
        {
            string cadena_de_conexion = "server=" + this.nombre_de_host + ";";
            cadena_de_conexion += "user=" + this.usuario + ";";
            cadena_de_conexion += "password=" + this.contraseña + ";";
            cadena_de_conexion += "port=" + this.puerto + ";";
            cadena_de_conexion += "database=" + this.base_de_datos+ ";";            
            return cadena_de_conexion;
        }
    }
}
