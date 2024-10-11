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
    public class LineaBo
    {
        private LineaDAO lineaDAO;

        public LineaBo()
        {
            this.lineaDAO = new LineaDAOImpl();
        }

        public BindingList<Object> listarTodos()
        {
            return this.lineaDAO.listarTodos();
        }

        public BindingList<Object> listarPorGrupo(int? idGrupo)
        {
            return this.lineaDAO.listarPorGrupo(idGrupo);
        }

        public Linea obtenerPorId(int idGrupo, int idLinea)
        {
            return this.lineaDAO.obtenerPorId(idGrupo, idLinea);
        }
    }
}
