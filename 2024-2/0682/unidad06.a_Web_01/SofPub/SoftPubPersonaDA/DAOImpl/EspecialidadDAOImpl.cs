﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SofPubDBManager;
using SoftPubPersonaDA.DAO;

namespace SoftPubPersonaDA.DAOImpl
{
    public class EspecialidadDAOImpl : DAOImplBase, EspecialidadDAO
    {
        public EspecialidadDAOImpl() : base("especialidad")
        {
        }

        protected override void agregarObjetoALaLista(BindingList<object> lista, MySqlDataReader lector)
        {
            throw new NotImplementedException();
        }

        protected override string obtenerProyeccionParaSelect()
        {
            throw new NotImplementedException();
        }
    }
}
