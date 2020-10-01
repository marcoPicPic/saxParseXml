package org.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ParseMessageTest extends TestCase {

    private String test = "<urn:GetChedResponse xmlns:urn=\"urn:tracesfr:ched:service\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "    <urn:CHED>\n" +
            "        <ns0:document xmlns:ns0=\"urn:tracesfr:ched:service\">\n" +
            "            <ns0:referenceCHED>CHEDD.FR.2020.0001733</ns0:referenceCHED>\n" +
            "            <ns7:SPSCertificate xmlns:ns60=\"urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode_Invoice:D16B\" xmlns:ns2=\"http://ec.europa.eu/sanco/tracesnt/base/v4\" xmlns:ns4=\"urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:21\" xmlns:ns3=\"http://ec.europa.eu/tracesnt/certificate/ched/followup/v01\" xmlns:ns53=\"urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeCode:1996Rev2Final\" xmlns:ns6=\"http://ec.europa.eu/tracesnt/certificate/ched/v01\" xmlns:ns52=\"urn:un:unece:uncefact:codelist:standard:UNECE:CargoTypeClassificationCode:D16B\" xmlns:ns96=\"urn:un:unece:uncefact:identifierlist:standard:UNECE:PaymentTermsDescriptionIdentifier:D16B\" xmlns:ns5=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:21\" xmlns:ns51=\"urn:un:unece:uncefact:codelist:standard:UNECE:CargoOperationalCategoryCode:D16B\" xmlns:ns95=\"urn:un:unece:uncefact:identifierlist:standard:UNECE:FreightCostCode:4\" xmlns:ns8=\"http://ec.europa.eu/tracesnt/certificate/base/v01\" xmlns:ns7=\"urn:un:unece:uncefact:data:standard:SPSCertificate:17\" xmlns:ns50=\"urn:un:unece:uncefact:codelist:standard:UNECE:AutomaticDataCaptureMethodCode:D16B\" xmlns:ns94=\"urn:un:unece:uncefact:codelist:standard:UNECE:TransportMovementStageCode:D16B\" xmlns:ns13=\"urn:un:unece:uncefact:codelist:standard:6:0133:40106\" xmlns:ns57=\"urn:un:unece:uncefact:codelist:standard:UNECE:DimensionTypeCode:D16B\" xmlns:ns12=\"http://ec.europa.eu/tracesnt/body/v3\" xmlns:ns56=\"urn:un:unece:uncefact:codelist:standard:UNECE:DeliveryTermsCode:2010\" xmlns:ns9=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" xmlns:ns11=\"http://www.w3.org/2000/09/xmldsig#\" xmlns:ns55=\"urn:un:unece:uncefact:codelist:standard:UNECE:DeliveryPlanCommitmentLevelCode:D16B\" xmlns:ns10=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:ns54=\"urn:un:unece:uncefact:codelist:standard:UNECE:DangerousGoodsPackingCode:D16B\" xmlns:ns17=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingAccountStatus:D11A\" xmlns:ns16=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingAccountNatureType:D11A\" xmlns:ns15=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingAccountClassification:D11A\" xmlns:ns59=\"urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode_Accounting:D16B\" xmlns:ns14=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingAccountBalanceReopeningType:D11A\" xmlns:ns58=\"urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode:D16B\" xmlns:ns19=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingAmountType:D11A\" xmlns:ns18=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingAccountType:D11A\" xmlns:ns93=\"urn:un:unece:uncefact:codelist:standard:UNECE:TransportModeCode:2\" xmlns:ns92=\"urn:un:unece:uncefact:codelist:standard:UNECE:TransportMeansTypeCode:2007\" xmlns:ns91=\"urn:un:unece:uncefact:codelist:standard:UNECE:TransportEquipmentFullnessCode:D16B\" xmlns:ns90=\"urn:un:unece:uncefact:codelist:standard:UNECE:TimePointFormatCode:D16B\" xmlns:ns42=\"urn:un:unece:uncefact:codelist:standard:ISO:ISO2AlphaLanguageCode:2006-10-27\" xmlns:ns86=\"urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCode_AccountingDebitCredit:D16B\" xmlns:ns41=\"urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2013-01-23\" xmlns:ns85=\"urn:un:unece:uncefact:codelist:standard:UNECE:StatusCode:D16B\" xmlns:ns40=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:TaxExemptionReason:D11A\" xmlns:ns84=\"urn:un:unece:uncefact:codelist:standard:UNECE:ProcessTypeCode:D16B\" xmlns:ns83=\"urn:un:unece:uncefact:codelist:standard:UNECE:PriorityDescriptionCode:D16B\" xmlns:ns46=\"urn:un:unece:uncefact:codelist:standard:UNECE:AdjustmentReasonDescriptionCode_Financial:D16B\" xmlns:ns45=\"urn:un:unece:uncefact:codelist:standard:UNECE:AdjustmentReasonDescriptionCode:D16B\" xmlns:ns89=\"urn:un:unece:uncefact:codelist:standard:UNECE:TimeOnlyFormatCode:D16B\" xmlns:ns44=\"urn:un:unece:uncefact:codelist:standard:UNECE:AddressType:D16B\" xmlns:ns88=\"urn:un:unece:uncefact:codelist:standard:UNECE:TemperatureTypeCode:D16B\" xmlns:ns43=\"urn:un:unece:uncefact:codelist:standard:UNECE:ActionCode:D16B\" xmlns:ns87=\"urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCode_Workflow:D16B\" xmlns:ns49=\"urn:un:unece:uncefact:codelist:standard:UNECE:AllowanceChargeReasonCode:D16B\" xmlns:ns48=\"urn:un:unece:uncefact:codelist:standard:UNECE:AllowanceChargeIdentificationCode:D16B\" xmlns:ns47=\"urn:un:unece:uncefact:codelist:standard:UNECE:AgencyIdentificationCode:D16B\" xmlns:ns82=\"urn:un:unece:uncefact:codelist:standard:UNECE:PaymentTermsTypeCode:D16B\" xmlns:ns81=\"urn:un:unece:uncefact:codelist:standard:UNECE:PaymentMethodCode:D16B\" xmlns:ns80=\"urn:un:unece:uncefact:codelist:standard:UNECE:PaymentMeansCode:D16B\" xmlns:ns31=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AddressFormatType:D11A\" xmlns:ns75=\"urn:un:unece:uncefact:codelist:standard:UNECE:PackageTypeCode:2006\" xmlns:ns30=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AdditionalPostponement:D11A\" xmlns:ns74=\"urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCode_Acknowledgement:D16B\" xmlns:ns73=\"urn:un:unece:uncefact:codelist:standard:UNECE:MessageFunctionCode:D16B\" xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns72=\"urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCode_FileSize:4\" xmlns:ns35=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:FinancialAccountType:D11A\" xmlns:ns79=\"urn:un:unece:uncefact:codelist:standard:UNECE:PaymentMeansChannelCode:D16B\" xmlns:ns34=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:CertificateType:D11A\" xmlns:ns78=\"urn:un:unece:uncefact:codelist:standard:UNECE:PaymentGuaranteeMeansCode:D16B\" xmlns:ns33=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AmortizationMethod:D11A\" xmlns:ns77=\"urn:un:unece:uncefact:codelist:standard:UNECE:PackagingMarkingCode:D16B\" xmlns:ns32=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AlternateCurrencyAmount:D11A\" xmlns:ns76=\"urn:un:unece:uncefact:codelist:standard:UNECE:PackagingLevelCode:D16B\" xmlns:ns39=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:ScenarioType:D11A\" xmlns:ns38=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:RefundMethod:D11A\" xmlns:ns37=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:OrganizationFunctionType:D11A\" xmlns:ns36=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:LifetimeEndCost:D11A\" xmlns:ns71=\"urn:un:unece:uncefact:codelist:standard:UNECE:MeasurementUnitCommonCode_Airflow:4\" xmlns:ns70=\"urn:un:unece:uncefact:codelist:standard:UNECE:MarkingInstructionCode:D16B\" xmlns:ns20=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingContact:D11A\" xmlns:ns64=\"urn:un:unece:uncefact:codelist:standard:UNECE:DocumentStatusCode:D16B\" xmlns:ns63=\"urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode_Scheduling:D16B\" xmlns:ns62=\"urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode_Remittance:D16B\" xmlns:ns61=\"urn:un:unece:uncefact:codelist:standard:UNECE:DocumentNameCode_Quotation:D16B\" xmlns:ns24=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingEntryProcessing:D11A\" xmlns:ns68=\"urn:un:unece:uncefact:codelist:standard:UNECE:GovernmentActionCode:D16B\" xmlns:ns23=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingEntryLineSource:D11A\" xmlns:ns67=\"urn:un:unece:uncefact:codelist:standard:UNECE:EventTimeReferenceCodePaymentTermsEvent:D16B\" xmlns:ns22=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingEntryLineCategory:D11A\" xmlns:ns66=\"urn:un:unece:uncefact:codelist:standard:UNECE:EventTimeReferenceCode:D16B\" xmlns:ns21=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingEntryCategory:D11A\" xmlns:ns65=\"urn:un:unece:uncefact:codelist:standard:UNECE:EquipmentSizeTypeDescriptionCode:D16B\" xmlns:ns28=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingPerquisite:D11A\" xmlns:ns27=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingPeriodFunctionType:D11A\" xmlns:ns26=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingJournalCategory:D11A\" xmlns:ns25=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingJournal:D11A\" xmlns:ns69=\"urn:un:unece:uncefact:codelist:standard:UNECE:LocationFunctionCode:D16B\" xmlns:ns29=\"urn:un:unece:uncefact:codelist:standard:EDIFICAS-EU:AccountingVoucherMedium:D11A\">\n" +
            "                <ns7:SPSExchangedDocument>\n" +
            "                    <ns4:Name languageID=\"fr\">DSCE-D - Common Health Entry Document for Feed and Food of Non-Animal Origin</ns4:Name>\n" +
            "                    <ns4:ID>CHEDD.FR.2020.0001733</ns4:ID>\n" +
            "                    <ns4:TypeCode name=\"Health certificate (CHED - Common Health Entry Document)\" listID=\"1001\" listAgencyID=\"6\" listVersionID=\"D16B\">636</ns4:TypeCode>\n" +
            "                    <ns4:StatusCode name=\"Issued (Validé)\" listID=\"4405\" listAgencyID=\"6\" listVersionID=\"D16B\">70</ns4:StatusCode>\n" +
            "                    <ns4:IssueDateTime>\n" +
            "                        <ns5:DateTime>2020-07-03T12:08:18+02:00</ns5:DateTime>\n" +
            "                    </ns4:IssueDateTime>\n" +
            "                    <ns4:IssuerSPSParty>\n" +
            "                        <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"authority_activity_id\" schemeName=\"Authority activity ID\">FRCDG4.</ns4:ID>\n" +
            "                        <ns4:Name>Roissy Charles-De-Gaulle FRCDG4</ns4:Name>\n" +
            "                        <ns4:RoleCode name=\"Officer (Identification of Applicant)\" listID=\"3035\" listAgencyID=\"6\" listVersionID=\"D16B\">VJ</ns4:RoleCode>\n" +
            "                        <ns4:TypeCode listID=\"user_body_role\" listName=\"User body role\" name=\"Authority\">AUTHORITY</ns4:TypeCode>\n" +
            "                        <ns4:SpecifiedSPSAddress>\n" +
            "                            <ns4:PostcodeCode>95701</ns4:PostcodeCode>\n" +
            "                            <ns4:LineOne>Zone de fret 1 - Rue du pélican\n" +
            "BP 10111</ns4:LineOne>\n" +
            "                            <ns4:CityName languageID=\"fr\">Roissy Ch De Gaulle Cedex</ns4:CityName>\n" +
            "                            <ns4:CountryID>FR</ns4:CountryID>\n" +
            "                            <ns4:CountryName languageID=\"fr\">France</ns4:CountryName>\n" +
            "                        </ns4:SpecifiedSPSAddress>\n" +
            "                        <ns4:SpecifiedSPSPerson>\n" +
            "                            <ns4:Name>BCP FR TWO</ns4:Name>\n" +
            "                        </ns4:SpecifiedSPSPerson>\n" +
            "                    </ns4:IssuerSPSParty>\n" +
            "                    <ns4:IncludedSPSNote>\n" +
            "                        <ns4:ContentCode listID=\"ched_type\" listName=\"CHED type\" name=\"CHED-D - Common Health Entry Document for Feed and Food of Non-Animal Origin\">D</ns4:ContentCode>\n" +
            "                        <ns4:Content/>\n" +
            "                        <ns4:SubjectCode listID=\"ched_note_subject_code\" listName=\"CHED Note SubjectCode list\" name=\"Type of CHED\">CHED_TYPE</ns4:SubjectCode>\n" +
            "                    </ns4:IncludedSPSNote>\n" +
            "                    <ns4:IncludedSPSNote>\n" +
            "                        <ns4:ContentCode listID=\"product_temperature\" listName=\"Product temperature\" name=\"Réfrigérée\">CHILLED</ns4:ContentCode>\n" +
            "                        <ns4:Content/>\n" +
            "                        <ns4:SubjectCode listID=\"certificate_note_subject_code\" listName=\"Certificate Note SubjectCode list\" name=\"Product temperature\">PRODUCT_TEMPERATURE</ns4:SubjectCode>\n" +
            "                    </ns4:IncludedSPSNote>\n" +
            "                    <ns4:IncludedSPSNote>\n" +
            "                        <ns4:Content>2020-07-03T12:08:18.000+02:00</ns4:Content>\n" +
            "                        <ns4:SubjectCode listID=\"ched_note_subject_code\" listName=\"CHED Note SubjectCode list\" name=\"Last updated\">LAST_UPDATE_DATETIME</ns4:SubjectCode>\n" +
            "                    </ns4:IncludedSPSNote>\n" +
            "                    <ns4:IncludedSPSNote>\n" +
            "                        <ns4:ContentCode listID=\"ched_internal_market_destination_type\" listName=\"CHED destination type for internal market\" name=\"Consommation humaine\">HUMAN_CONSUMPTION</ns4:ContentCode>\n" +
            "                        <ns4:Content/>\n" +
            "                        <ns4:SubjectCode listID=\"ched_note_subject_code\" listName=\"CHED Note SubjectCode list\" name=\"Destination type when acceptable for internal market\">ACCEPTABLE_INTERNAL_MARKET_DESTINATION_TYPE</ns4:SubjectCode>\n" +
            "                    </ns4:IncludedSPSNote>\n" +
            "                    <ns4:IncludedSPSNote>\n" +
            "                        <ns4:Content>0</ns4:Content>\n" +
            "                        <ns4:SubjectCode listID=\"ched_note_subject_code\" listName=\"CHED Note SubjectCode list\" name=\"Total number of laboratory tests on commodities\">LABORATORY_TESTS_COMMODITIES_TOTAL</ns4:SubjectCode>\n" +
            "                    </ns4:IncludedSPSNote>\n" +
            "                    <ns4:IncludedSPSNote>\n" +
            "                        <ns4:Content>0</ns4:Content>\n" +
            "                        <ns4:SubjectCode listID=\"ched_note_subject_code\" listName=\"CHED Note SubjectCode list\" name=\"Number of satisfactory laboratory tests on commodities\">LABORATORY_TESTS_COMMODITIES_SATISFACTORY</ns4:SubjectCode>\n" +
            "                    </ns4:IncludedSPSNote>\n" +
            "                    <ns4:IncludedSPSNote>\n" +
            "                        <ns4:Content>0</ns4:Content>\n" +
            "                        <ns4:SubjectCode listID=\"ched_note_subject_code\" listName=\"CHED Note SubjectCode list\" name=\"Number of not-satisfactory laboratory tests on commodities\">LABORATORY_TESTS_COMMODITIES_NOT_SATISFACTORY</ns4:SubjectCode>\n" +
            "                    </ns4:IncludedSPSNote>\n" +
            "                    <ns4:IncludedSPSNote>\n" +
            "                        <ns4:Content>0</ns4:Content>\n" +
            "                        <ns4:SubjectCode listID=\"ched_note_subject_code\" listName=\"CHED Note SubjectCode list\" name=\"Number of pending laboratory tests on commodities\">LABORATORY_TESTS_COMMODITIES_PENDING</ns4:SubjectCode>\n" +
            "                    </ns4:IncludedSPSNote>\n" +
            "                    <ns4:ReferenceSPSReferencedDocument>\n" +
            "                        <ns4:TypeCode name=\"Health certificate (CHED - Common Health Entry Document)\" listID=\"1001\" listAgencyID=\"6\" listVersionID=\"D16B\">636</ns4:TypeCode>\n" +
            "                        <ns4:RelationshipTypeCode name=\"Document reference, internal (Document reference, internal)\" listID=\"1153_ReferenceTypeCode\" listAgencyID=\"6\" listVersionID=\"D16B\">CAW</ns4:RelationshipTypeCode>\n" +
            "                        <ns4:ID>CHEDD.FR.2020.0001733</ns4:ID>\n" +
            "                        <ns4:AttachmentBinaryObject format=\"url\" mimeCode=\"text/url\" uri=\"https://webgate.acceptance.ec.europa.eu/tracesnt/certificate/ched/CHEDD.FR.2020.0001733\"/>\n" +
            "                    </ns4:ReferenceSPSReferencedDocument>\n" +
            "                    <ns4:ReferenceSPSReferencedDocument>\n" +
            "                        <ns4:TypeCode name=\"Call-off delivery (Split from &lt;&lt;)\" listID=\"1001\" listAgencyID=\"6\" listVersionID=\"D16B\">76</ns4:TypeCode>\n" +
            "                        <ns4:RelationshipTypeCode name=\"Split delivery number (Split)\" listID=\"1153_ReferenceTypeCode\" listAgencyID=\"6\" listVersionID=\"D16B\">AXG</ns4:RelationshipTypeCode>\n" +
            "                        <ns4:ID>CHEDD.FR.2020.0001732</ns4:ID>\n" +
            "                    </ns4:ReferenceSPSReferencedDocument>\n" +
            "                    <ns4:SignatorySPSAuthentication>\n" +
            "                        <ns4:TypeCode name=\"Inspection (Identification of Applicant)\" listID=\"9417\" listAgencyID=\"6\" listVersionID=\"D16B\">4</ns4:TypeCode>\n" +
            "                        <ns4:ActualDateTime>\n" +
            "                            <ns5:DateTime>2020-07-03T12:08:18+02:00</ns5:DateTime>\n" +
            "                        </ns4:ActualDateTime>\n" +
            "                        <ns4:ProviderSPSParty>\n" +
            "                            <ns4:Name/>\n" +
            "                        </ns4:ProviderSPSParty>\n" +
            "                        <ns4:IncludedSPSClause>\n" +
            "                            <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"ched_consignment_clause\" schemeName=\"CHED consignment's clauses\">PURPOSE</ns4:ID>\n" +
            "                            <ns4:Content>INTERNAL_MARKET</ns4:Content>\n" +
            "                            <ns4:Content languageID=\"fr\">For free circulation</ns4:Content>\n" +
            "                        </ns4:IncludedSPSClause>\n" +
            "                        <ns4:IncludedSPSClause>\n" +
            "                            <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"ched_consignment_clause\" schemeName=\"CHED consignment's clauses\">GOODS_CERTIFIED_AS</ns4:ID>\n" +
            "                            <ns4:Content>FURTHER_PROCESS</ns4:Content>\n" +
            "                            <ns4:Content languageID=\"fr\">Transformation</ns4:Content>\n" +
            "                        </ns4:IncludedSPSClause>\n" +
            "                        <ns4:IncludedSPSClause>\n" +
            "                            <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"ched_consignment_clause\" schemeName=\"CHED consignment's clauses\">SIGNATORY_PERSON_EMAIL</ns4:ID>\n" +
            "                            <ns4:Content>BCP02.FR@ec-traces.eu</ns4:Content>\n" +
            "                        </ns4:IncludedSPSClause>\n" +
            "                    </ns4:SignatorySPSAuthentication>\n" +
            "                    <ns4:SignatorySPSAuthentication>\n" +
            "                        <ns4:TypeCode name=\"Clearance (Official inspector)\" listID=\"9417\" listAgencyID=\"6\" listVersionID=\"D16B\">1</ns4:TypeCode>\n" +
            "                        <ns4:ActualDateTime>\n" +
            "                            <ns5:DateTime>2020-07-03T12:08:18+02:00</ns5:DateTime>\n" +
            "                        </ns4:ActualDateTime>\n" +
            "                        <ns4:ProviderSPSParty>\n" +
            "                            <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"authority_activity_id\" schemeName=\"Authority activity ID\">FRCDG4.</ns4:ID>\n" +
            "                            <ns4:Name>Roissy Charles-De-Gaulle FRCDG4</ns4:Name>\n" +
            "                            <ns4:RoleCode name=\"Authorized official\" listID=\"3035\" listAgencyID=\"6\" listVersionID=\"D16B\">AM</ns4:RoleCode>\n" +
            "                            <ns4:TypeCode listID=\"user_body_role\" listName=\"User body role\" name=\"Authority\">AUTHORITY</ns4:TypeCode>\n" +
            "                            <ns4:SpecifiedSPSAddress>\n" +
            "                                <ns4:PostcodeCode>95701</ns4:PostcodeCode>\n" +
            "                                <ns4:LineOne>Zone de fret 1 - Rue du pélican\n" +
            "BP 10111</ns4:LineOne>\n" +
            "                                <ns4:CityName languageID=\"fr\">Roissy Ch De Gaulle Cedex</ns4:CityName>\n" +
            "                                <ns4:CountryID>FR</ns4:CountryID>\n" +
            "                                <ns4:CountryName languageID=\"fr\">France</ns4:CountryName>\n" +
            "                            </ns4:SpecifiedSPSAddress>\n" +
            "                            <ns4:SpecifiedSPSPerson>\n" +
            "                                <ns4:Name>BCP FR TWO</ns4:Name>\n" +
            "                            </ns4:SpecifiedSPSPerson>\n" +
            "                        </ns4:ProviderSPSParty>\n" +
            "                        <ns4:IncludedSPSClause>\n" +
            "                            <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"ched_decision_clause\" schemeName=\"CHED decision's clauses\">DECISION_CONCLUSION</ns4:ID>\n" +
            "                            <ns4:Content>ACCEPTABLE_FOR_INTERNAL_MARKET</ns4:Content>\n" +
            "                            <ns4:Content languageID=\"fr\">Admissibilité à la mise en libre pratique</ns4:Content>\n" +
            "                        </ns4:IncludedSPSClause>\n" +
            "                        <ns4:IncludedSPSClause>\n" +
            "                            <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"ched_decision_clause\" schemeName=\"CHED decision's clauses\">DOCUMENTARY_CHECK</ns4:ID>\n" +
            "                            <ns4:Content>YES</ns4:Content>\n" +
            "                            <ns4:Content languageID=\"fr\">Oui</ns4:Content>\n" +
            "                        </ns4:IncludedSPSClause>\n" +
            "                        <ns4:IncludedSPSClause>\n" +
            "                            <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"ched_decision_clause\" schemeName=\"CHED decision's clauses\">DOCUMENTARY_CHECK_RESULT</ns4:ID>\n" +
            "                            <ns4:Content>SATISFACTORY</ns4:Content>\n" +
            "                            <ns4:Content languageID=\"fr\">Satisfaisant</ns4:Content>\n" +
            "                        </ns4:IncludedSPSClause>\n" +
            "                        <ns4:IncludedSPSClause>\n" +
            "                            <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"ched_decision_clause\" schemeName=\"CHED decision's clauses\">SIGNATORY_PERSON_EMAIL</ns4:ID>\n" +
            "                            <ns4:Content>BCP02.FR@ec-traces.eu</ns4:Content>\n" +
            "                        </ns4:IncludedSPSClause>\n" +
            "                    </ns4:SignatorySPSAuthentication>\n" +
            "                </ns7:SPSExchangedDocument>\n" +
            "                <ns7:SPSConsignment>\n" +
            "                    <ns4:AvailabilityDueDateTime>\n" +
            "                        <ns5:DateTime>2020-07-03T12:05:00+02:00</ns5:DateTime>\n" +
            "                    </ns4:AvailabilityDueDateTime>\n" +
            "                    <ns4:ConsignorSPSParty>\n" +
            "                        <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"operator_internal_activity_id\" schemeName=\"Operator internal activity ID\">41519</ns4:ID>\n" +
            "                        <ns4:Name>COOPERATIVEAA45 Ent</ns4:Name>\n" +
            "                        <ns4:RoleCode name=\"Exporter\" listID=\"3035\" listAgencyID=\"6\" listVersionID=\"D16B\">EX</ns4:RoleCode>\n" +
            "                        <ns4:TypeCode listID=\"operator_activity_type\" listName=\"Operator activity type\" name=\"Opérateur professionnel (végétaux, produits végétaux et autres objets)\">PLANT_ESTABLISHMENT</ns4:TypeCode>\n" +
            "                        <ns4:TypeCode listID=\"classification_section_code\" listName=\"Operator classification section code\" name=\"Etablissement végétal\">PLANTS</ns4:TypeCode>\n" +
            "                        <ns4:SpecifiedSPSAddress>\n" +
            "                            <ns4:LineOne>Generaal Charles 52</ns4:LineOne>\n" +
            "                            <ns4:CityName languageID=\"fr\">Agadir</ns4:CityName>\n" +
            "                            <ns4:CountryID>MA</ns4:CountryID>\n" +
            "                            <ns4:CountryName languageID=\"fr\">Maroc</ns4:CountryName>\n" +
            "                            <ns4:CountrySubDivisionName languageID=\"fr\">Préfecture d'Agadir Ida-Outanane</ns4:CountrySubDivisionName>\n" +
            "                        </ns4:SpecifiedSPSAddress>\n" +
            "                    </ns4:ConsignorSPSParty>\n" +
            "                    <ns4:ConsigneeSPSParty>\n" +
            "                        <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"national_registry_number\" schemeName=\"National registry number\">NL0000004261</ns4:ID>\n" +
            "                        <ns4:Name>COLIN PALC SAS</ns4:Name>\n" +
            "                        <ns4:RoleCode name=\"Consignee (Importer)\" listID=\"3035\" listAgencyID=\"6\" listVersionID=\"D16B\">CN</ns4:RoleCode>\n" +
            "                        <ns4:TypeCode listID=\"operator_activity_type\" listName=\"Operator activity type\" name=\"Importateur\">IMPORTER</ns4:TypeCode>\n" +
            "                        <ns4:TypeCode listID=\"classification_section_code\" listName=\"Operator classification section code\" name=\"Aliments pour animaux et denrées alimentaires d'origine non-animale\">NON_ANIMAL_ORIGIN_FOOD_AND_FEED</ns4:TypeCode>\n" +
            "                        <ns4:SpecifiedSPSAddress>\n" +
            "                            <ns4:PostcodeCode>67170</ns4:PostcodeCode>\n" +
            "                            <ns4:LineOne>RUE PRINCIPALE 17 ..</ns4:LineOne>\n" +
            "                            <ns4:CityName languageID=\"fr\">Mittelhausen</ns4:CityName>\n" +
            "                            <ns4:CountryID>FR</ns4:CountryID>\n" +
            "                            <ns4:CountryName languageID=\"fr\">France</ns4:CountryName>\n" +
            "                            <ns4:CountrySubDivisionName languageID=\"fr\">Bas-Rhin</ns4:CountrySubDivisionName>\n" +
            "                        </ns4:SpecifiedSPSAddress>\n" +
            "                    </ns4:ConsigneeSPSParty>\n" +
            "                    <ns4:ExportSPSCountry>\n" +
            "                        <ns4:ID>MA</ns4:ID>\n" +
            "                        <ns4:Name languageID=\"fr\">Maroc</ns4:Name>\n" +
            "                    </ns4:ExportSPSCountry>\n" +
            "                    <ns4:ImportSPSCountry>\n" +
            "                        <ns4:ID/>\n" +
            "                        <ns4:Name/>\n" +
            "                    </ns4:ImportSPSCountry>\n" +
            "                    <ns4:UnloadingBaseportSPSLocation>\n" +
            "                        <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"authority_activity_id\" schemeName=\"Authority activity ID\">FRCDG4.</ns4:ID>\n" +
            "                        <ns4:Name>FR</ns4:Name>\n" +
            "                        <ns4:Name languageID=\"fr\">Roissy Ch De Gaulle Cedex</ns4:Name>\n" +
            "                        <ns4:Name>FRCDG4.</ns4:Name>\n" +
            "                        <ns4:Name>Roissy Charles-De-Gaulle FRCDG4</ns4:Name>\n" +
            "                        <ns4:Name>Zone de fret 1 - Rue du pélican\n" +
            "BP 10111</ns4:Name>\n" +
            "                    </ns4:UnloadingBaseportSPSLocation>\n" +
            "                    <ns4:ExaminationSPSEvent>\n" +
            "                        <ns4:OccurrenceSPSLocation>\n" +
            "                            <ns4:Name/>\n" +
            "                        </ns4:OccurrenceSPSLocation>\n" +
            "                    </ns4:ExaminationSPSEvent>\n" +
            "                    <ns4:DeliverySPSParty>\n" +
            "                        <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"operator_activity_id\" schemeName=\"Operator activity ID\">garte123</ns4:ID>\n" +
            "                        <ns4:Name>COOPERATIVEEO90 WW</ns4:Name>\n" +
            "                        <ns4:RoleCode name=\"Delivery party (Place of destination)\" listID=\"3035\" listAgencyID=\"6\" listVersionID=\"D16B\">DP</ns4:RoleCode>\n" +
            "                        <ns4:TypeCode listID=\"operator_activity_type\" listName=\"Operator activity type\" name=\"Intéressé au chargement\">RESPONSIBLE_FOR_THE_LOAD</ns4:TypeCode>\n" +
            "                        <ns4:TypeCode listID=\"classification_section_code\" listName=\"Operator classification section code\" name=\"Responsable au chargement (RFL)\">RFL</ns4:TypeCode>\n" +
            "                        <ns4:SpecifiedSPSAddress>\n" +
            "                            <ns4:PostcodeCode>9444</ns4:PostcodeCode>\n" +
            "                            <ns4:LineOne>Banat Street 89</ns4:LineOne>\n" +
            "                            <ns4:CityName languageID=\"fr\">Fertőszentmiklós</ns4:CityName>\n" +
            "                            <ns4:CountryID>HU</ns4:CountryID>\n" +
            "                            <ns4:CountryName languageID=\"fr\">Hongrie</ns4:CountryName>\n" +
            "                            <ns4:CountrySubDivisionName languageID=\"fr\">Győr-Moson-Sopron</ns4:CountrySubDivisionName>\n" +
            "                        </ns4:SpecifiedSPSAddress>\n" +
            "                    </ns4:DeliverySPSParty>\n" +
            "                    <ns4:CustomsTransitAgentSPSParty>\n" +
            "                        <ns4:ID schemeAgencyID=\"ec_sante_traces\" schemeAgencyName=\"European commission - DG SANTE - Traces\" schemeID=\"operator_activity_id\" schemeName=\"Operator activity ID\">FR-0023235</ns4:ID>\n" +
            "                        <ns4:Name>AIR FRANCE CARGO</ns4:Name>\n" +
            "                        <ns4:RoleCode name=\"Customs broker (Responsible for consignment)\" listID=\"3035\" listAgencyID=\"6\" listVersionID=\"D16B\">CB</ns4:RoleCode>\n" +
            "                        <ns4:TypeCode listID=\"operator_activity_type\" listName=\"Operator activity type\" name=\"Intéressé au chargement\">RESPONSIBLE_FOR_THE_LOAD</ns4:TypeCode>\n" +
            "                        <ns4:TypeCode listID=\"classification_section_code\" listName=\"Operator classification section code\" name=\"Responsable au chargement (RFL)\">RFL</ns4:TypeCode>\n" +
            "                        <ns4:SpecifiedSPSAddress>\n" +
            "                            <ns4:PostcodeCode>95700</ns4:PostcodeCode>\n" +
            "                            <ns4:LineOne>sfd</ns4:LineOne>\n" +
            "                            <ns4:CityName languageID=\"fr\">Roissy-en-France</ns4:CityName>\n" +
            "                            <ns4:CountryID>FR</ns4:CountryID>\n" +
            "                            <ns4:CountryName languageID=\"fr\">France</ns4:CountryName>\n" +
            "                            <ns4:CountrySubDivisionName languageID=\"fr\">Val-d'Oise</ns4:CountrySubDivisionName>\n" +
            "                        </ns4:SpecifiedSPSAddress>\n" +
            "                    </ns4:CustomsTransitAgentSPSParty>\n" +
            "                    <ns4:MainCarriageSPSTransportMovement>\n" +
            "                        <ns4:ID schemeID=\"airplane_flight_number_before_bcp\" schemeName=\"Flight number (before BCP)\">11111111111111111111</ns4:ID>\n" +
            "                        <ns4:ModeCode name=\"Air transport\" listID=\"Recommendation 19\" listAgencyID=\"6\" listVersionID=\"2\">4</ns4:ModeCode>\n" +
            "                    </ns4:MainCarriageSPSTransportMovement>\n" +
            "                    <ns4:IncludedSPSConsignmentItem>\n" +
            "                        <ns4:NatureIdentificationSPSCargo>\n" +
            "                            <ns4:TypeCode name=\"General cargo (Commodities)\" listID=\"7085\" listAgencyID=\"6\" listVersionID=\"D16B\">12</ns4:TypeCode>\n" +
            "                        </ns4:NatureIdentificationSPSCargo>\n" +
            "                        <ns4:IncludedSPSTradeLineItem>\n" +
            "                            <ns4:SequenceNumeric>0</ns4:SequenceNumeric>\n" +
            "                            <ns4:Description>Consignment totals and summary</ns4:Description>\n" +
            "                            <ns4:NetWeightMeasure unitCode=\"KGM\">6</ns4:NetWeightMeasure>\n" +
            "                            <ns4:PhysicalSPSPackage>\n" +
            "                                <ns4:LevelCode name=\"No packaging hierarchy\">4</ns4:LevelCode>\n" +
            "                                <ns4:TypeCode listID=\"7065\" listAgencyID=\"6\" listVersionID=\"2006\">NA</ns4:TypeCode>\n" +
            "                                <ns4:ItemQuantity>0</ns4:ItemQuantity>\n" +
            "                            </ns4:PhysicalSPSPackage>\n" +
            "                        </ns4:IncludedSPSTradeLineItem>\n" +
            "                        <ns4:IncludedSPSTradeLineItem>\n" +
            "                            <ns4:SequenceNumeric>1</ns4:SequenceNumeric>\n" +
            "                            <ns4:Description/>\n" +
            "                            <ns4:NetWeightMeasure unitCode=\"KGM\">6</ns4:NetWeightMeasure>\n" +
            "                            <ns4:ApplicableSPSClassification>\n" +
            "                                <ns4:SystemID>CN</ns4:SystemID>\n" +
            "                                <ns4:SystemName>CN Code (Combined Nomenclature)</ns4:SystemName>\n" +
            "                                <ns4:ClassCode>07020000</ns4:ClassCode>\n" +
            "                                <ns4:ClassName languageID=\"fr\">LÉGUMES, PLANTES, RACINES ET TUBERCULES ALIMENTAIRES</ns4:ClassName>\n" +
            "                                <ns4:ClassName languageID=\"fr\">Tomates, à l'état frais ou réfrigéré</ns4:ClassName>\n" +
            "                            </ns4:ApplicableSPSClassification>\n" +
            "                            <ns4:OriginSPSCountry>\n" +
            "                                <ns4:ID>MA</ns4:ID>\n" +
            "                                <ns4:Name languageID=\"fr\">Maroc</ns4:Name>\n" +
            "                            </ns4:OriginSPSCountry>\n" +
            "                        </ns4:IncludedSPSTradeLineItem>\n" +
            "                    </ns4:IncludedSPSConsignmentItem>\n" +
            "                </ns7:SPSConsignment>\n" +
            "            </ns7:SPSCertificate>\n" +
            "        </ns0:document>\n" +
            "        <urn:listeImputations>\n" +
            "            <urn:imputation>\n" +
            "                <urn:nomenclature>07020000</urn:nomenclature>\n" +
            "                <urn:numLigne>1</urn:numLigne>\n" +
            "                <urn:quantiteDisponible>6.000000000</urn:quantiteDisponible>\n" +
            "                <urn:uniteImputation>KGM</urn:uniteImputation>\n" +
            "                <urn:details/>\n" +
            "            </urn:imputation>\n" +
            "        </urn:listeImputations>\n" +
            "    </urn:CHED>\n" +
            "</urn:GetChedResponse>";

    @Test
    public void testXml() throws IOException, SAXException, ParserConfigurationException {
        ParseMessage parseMessage = new ParseMessage();
        parseMessage.apply(test);
    }

}