package mappers;

public interface EntityMapper<ENT, DTO> {
    DTO entityToDto(ENT entity);
    ENT dtoToEntity(DTO dto);
}
