using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubGrupoControler.DAO;
using SoftPubGrupoControler.DAOImpl;
using SoftPubGrupoModel;

namespace SoftPubGrupoBussiness
{
    public class GrupoBo
    {
        private GrupoDAO grupoDAO;

        public GrupoBo()
        {
            this.grupoDAO = new GrupoDAOImpl();
        }

        public int? insertar(String nombre, String sigla)
        {
            Grupo grupo = new Grupo(null, nombre, sigla);
            return this.grupoDAO.insertar(grupo);
        }

        public BindingList<Object> listarTodos()
        {
            return this.grupoDAO.listarTodos();
        }

        public BindingList<Object> listarGruposConProduccion()
        {
            return this.grupoDAO.listarGruposConProduccion();
        }

        public BindingList<Object> buscarGrupos(string nombre)
        {
            return this.grupoDAO.buscarGrupos(nombre);
        }

        public Grupo obtenerPorId(int idGrupo)
        {
            return this.grupoDAO.obtenerPorId(idGrupo);
        }
    }
}
