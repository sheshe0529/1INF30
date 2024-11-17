select 
	e.idEspecialidad, 
    e.especialidad, 
    e.facultad, 
    e.nivel,
    p.idPersona,
    p.paterno,
    p.materno,
    p.nombre,
    p.genero,
    a.matriculado
from especialidad e
join alumno a on e.idEspecialidad = a.idEspecialidad
join persona p on a.idPersona = p.idPersona
where ((e.idEspecialidad=pEspecialidad) or (e.idEspecialidad!=0 and pEspecialidad=0))